package com.informatorio.comercio.repository;

import com.informatorio.comercio.domain.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long>{
    Direccion getById(Long id);
    Direccion getByCiudad(String ciudad);
}
