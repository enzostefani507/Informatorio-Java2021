package com.informatorio.comp_lev_1_spring_rest.repository;

import org.springframework.stereotype.Repository;
import com.informatorio.comp_lev_1_spring_rest.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
    Usuario getById(Long id);
}
