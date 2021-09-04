package com.informatorio.comercio.repository;

import com.informatorio.comercio.domain.Detalle;
import com.informatorio.comercio.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {
    Detalle getById(Long id);
    Boolean existsByProducto(Producto producto);
}
