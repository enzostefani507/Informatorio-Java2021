package com.informatorio.comercio.repository;

import com.informatorio.comercio.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Producto getById(Long id);
    List<Producto> findByNombreStartingWith(String nombre);
}