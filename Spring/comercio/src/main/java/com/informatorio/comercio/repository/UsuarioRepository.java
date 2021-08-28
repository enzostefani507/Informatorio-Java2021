package com.informatorio.comercio.repository;

import com.informatorio.comercio.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario getById(Long id);
    List<Usuario> getByDireccionCiudad(String ciudad);
    //List<Usuario> getByFechacreacion(Date fecha);
}
