package com.utp.cochera.repository;

import com.utp.cochera.model.RegistroEstacionamiento;
import com.utp.cochera.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistroEstacionamientoRepository extends JpaRepository<RegistroEstacionamiento, Long> {
    Optional<RegistroEstacionamiento> findByVehiculoAndCerradoFalse(Vehiculo vehiculo);
    long countByCerradoFalse();
}
