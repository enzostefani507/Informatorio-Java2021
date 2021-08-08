package com.informatorio.comercio.repository;

import com.informatorio.comercio.domain.Carrito;
import com.informatorio.comercio.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    Carrito getById(Long id);
}
