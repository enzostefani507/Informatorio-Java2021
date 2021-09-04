package com.informatorio.comercio.repository;

import com.informatorio.comercio.domain.Orden;
import com.informatorio.comercio.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    Orden getById(Long id);
    List<Orden> findByUsuario(Usuario usuario);
    Orden findByCarritoId(Long id_carrito);
}
