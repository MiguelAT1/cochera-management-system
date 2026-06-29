package com.utp.cochera.service;

import com.utp.cochera.exception.RecursoNoEncontradoException;
import com.utp.cochera.model.Vehiculo;
import com.utp.cochera.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<Vehiculo> listar() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo buscarPorId(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Vehiculo no encontrado"));
    }

    public Vehiculo crear(Vehiculo vehiculo) {
        vehiculo.setPlaca(vehiculo.getPlaca().toUpperCase());
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo actualizar(Long id, Vehiculo datos) {
        Vehiculo vehiculo = buscarPorId(id);
        vehiculo.setPlaca(datos.getPlaca().toUpperCase());
        vehiculo.setPropietario(datos.getPropietario());
        vehiculo.setTipo(datos.getTipo());
        return vehiculoRepository.save(vehiculo);
    }

    public void eliminar(Long id) {
        Vehiculo vehiculo = buscarPorId(id);
        vehiculoRepository.delete(vehiculo);
    }
}
