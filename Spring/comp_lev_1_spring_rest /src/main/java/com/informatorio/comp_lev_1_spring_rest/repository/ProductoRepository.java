package com.informatorio.comp_lev_1_spring_rest.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.informatorio.comp_lev_1_spring_rest.domain.Producto;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long>{
    Optional<Producto> findById(Long id);
}
