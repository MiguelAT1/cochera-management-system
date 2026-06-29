package com.utp.cochera.service;

import com.utp.cochera.exception.RecursoNoEncontradoException;
import com.utp.cochera.exception.ReglaNegocioException;
import com.utp.cochera.model.EstadoVehiculo;
import com.utp.cochera.model.RegistroEstacionamiento;
import com.utp.cochera.model.Vehiculo;
import com.utp.cochera.repository.RegistroEstacionamientoRepository;
import com.utp.cochera.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CocheraService {
    private static final int CAPACIDAD_MAXIMA = 40;
    private final VehiculoRepository vehiculoRepository;
    private final RegistroEstacionamientoRepository registroRepository;

    public CocheraService(VehiculoRepository vehiculoRepository, RegistroEstacionamientoRepository registroRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.registroRepository = registroRepository;
    }

    public RegistroEstacionamiento registrarEntrada(String placa) {
        Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa.toUpperCase())
                .orElseThrow(() -> new RecursoNoEncontradoException("Vehiculo no registrado"));

        if (vehiculo.getEstado() == EstadoVehiculo.DENTRO) {
            throw new ReglaNegocioException("El vehiculo ya se encuentra dentro de la cochera");
        }

        if (registroRepository.countByCerradoFalse() >= CAPACIDAD_MAXIMA) {
            throw new ReglaNegocioException("La cochera llego a su capacidad maxima");
        }

        vehiculo.setEstado(EstadoVehiculo.DENTRO);
        vehiculo.setVisitas(vehiculo.getVisitas() + 1);
        vehiculoRepository.save(vehiculo);

        return registroRepository.save(new RegistroEstacionamiento(vehiculo));
    }

    public RegistroEstacionamiento registrarSalida(String placa) {
        Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa.toUpperCase())
                .orElseThrow(() -> new RecursoNoEncontradoException("Vehiculo no registrado"));

        RegistroEstacionamiento registro = registroRepository.findByVehiculoAndCerradoFalse(vehiculo)
                .orElseThrow(() -> new ReglaNegocioException("No existe una entrada activa para este vehiculo"));

        registro.setFechaSalida(LocalDateTime.now());
        registro.setMontoPagado(calcularMonto(vehiculo));
        registro.setCerrado(true);

        vehiculo.setEstado(EstadoVehiculo.FUERA);
        vehiculoRepository.save(vehiculo);

        return registroRepository.save(registro);
    }

    private double calcularMonto(Vehiculo vehiculo) {
        double tarifaBase = 5.0;
        if (vehiculo.getVisitas() >= 40) return 0.0;
        if (vehiculo.getVisitas() >= 20) return tarifaBase * 0.5;
        return tarifaBase;
    }

    public List<RegistroEstacionamiento> listarRegistros() {
        return registroRepository.findAll();
    }

    public String obtenerPromocion(String placa) {
        Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa.toUpperCase())
                .orElseThrow(() -> new RecursoNoEncontradoException("Vehiculo no registrado"));

        if (vehiculo.getVisitas() >= 40) return "Promocion: estacionamiento gratis por cliente frecuente";
        if (vehiculo.getVisitas() >= 20) return "Promocion: 50% de descuento por superar 20 visitas";
        return "Sin promocion activa. Visitas actuales: " + vehiculo.getVisitas();
    }
}
