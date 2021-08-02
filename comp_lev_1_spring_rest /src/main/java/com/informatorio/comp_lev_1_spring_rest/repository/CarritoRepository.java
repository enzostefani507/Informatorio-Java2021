package com.informatorio.comp_lev_1_spring_rest.repository;

import org.springframework.stereotype.Repository;
import com.informatorio.comp_lev_1_spring_rest.domain.Carrito;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CarritoRepository extends CrudRepository<Carrito,Long>{
    Carrito getById(Long id);
}
