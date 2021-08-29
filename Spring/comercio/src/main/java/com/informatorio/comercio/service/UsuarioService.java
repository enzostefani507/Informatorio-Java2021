package com.informatorio.comercio.service;

import com.informatorio.comercio.domain.Usuario;
import com.informatorio.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class UsuarioService {

    @Autowired
    private static UsuarioRepository usuarioRepository;

    public static Date creacion(){
        return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    };

    public static Usuario modificarCredenciales(Usuario user, Usuario usuario){
        user.setPassword(usuario.pwd());
        user.setEmail(usuario.getEmail());
        return usuarioRepository.save(user);
    }

    public static Usuario modificarDatos(Usuario user, Usuario usuario){
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setDireccion(usuario.getDireccion());
        return usuarioRepository.save(user);
    }
}
