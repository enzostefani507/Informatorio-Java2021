package com.informatorio.comp_lev_1_spring_rest.repository;

import org.springframework.stereotype.Repository;
import com.informatorio.comp_lev_1_spring_rest.domain.Producto;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long>{
    Producto getById(Long id);
}
