package com.informatorio.comercio.repository;

import com.informatorio.comercio.domain.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRepository extends JpaRepository<Detalle, Long> {
    Detalle getById(Long id);
}
