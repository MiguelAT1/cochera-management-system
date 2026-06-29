package com.utp.cochera.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RegistroEstacionamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehiculo vehiculo;

    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private double montoPagado;
    private boolean cerrado;

    public RegistroEstacionamiento() {}

    public RegistroEstacionamiento(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.fechaEntrada = LocalDateTime.now();
        this.cerrado = false;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public LocalDateTime getFechaEntrada() { return fechaEntrada; }
    public void setFechaEntrada(LocalDateTime fechaEntrada) { this.fechaEntrada = fechaEntrada; }
    public LocalDateTime getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDateTime fechaSalida) { this.fechaSalida = fechaSalida; }
    public double getMontoPagado() { return montoPagado; }
    public void setMontoPagado(double montoPagado) { this.montoPagado = montoPagado; }
    public boolean isCerrado() { return cerrado; }
    public void setCerrado(boolean cerrado) { this.cerrado = cerrado; }
}
