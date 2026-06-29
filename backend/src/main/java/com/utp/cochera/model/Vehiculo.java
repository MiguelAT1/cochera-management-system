package com.utp.cochera.model;

import jakarta.persistence.*;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String placa;

    private String propietario;
    private String tipo;
    private int visitas;

    @Enumerated(EnumType.STRING)
    private EstadoVehiculo estado = EstadoVehiculo.FUERA;

    public Vehiculo() {}

    public Vehiculo(String placa, String propietario, String tipo) {
        this.placa = placa;
        this.propietario = propietario;
        this.tipo = tipo;
        this.visitas = 0;
        this.estado = EstadoVehiculo.FUERA;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getPropietario() { return propietario; }
    public void setPropietario(String propietario) { this.propietario = propietario; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getVisitas() { return visitas; }
    public void setVisitas(int visitas) { this.visitas = visitas; }
    public EstadoVehiculo getEstado() { return estado; }
    public void setEstado(EstadoVehiculo estado) { this.estado = estado; }
}
