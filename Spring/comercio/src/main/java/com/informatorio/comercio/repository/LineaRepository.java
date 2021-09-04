package com.informatorio.comercio.repository;

import com.informatorio.comercio.domain.Linea;
import com.informatorio.comercio.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaRepository extends JpaRepository<Linea, Long> {
    Linea getById(Long id);
    Boolean existsByProductoId(Long producto_id);
}
