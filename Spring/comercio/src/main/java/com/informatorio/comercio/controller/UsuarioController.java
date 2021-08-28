package com.informatorio.comercio.controller;
import com.informatorio.comercio.domain.Usuario;
import com.informatorio.comercio.repository.DireccionRepository;
import com.informatorio.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class UsuarioController {

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(value = "/usuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario){return usuarioRepository.save(usuario);}

    @GetMapping(value = "/usuario")
    public List<Usuario> verUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping(value = "/usuario/{id}")
    public Usuario verUsuario(@PathVariable("id") Long id){
        return usuarioRepository.getById(id);
    }

    @DeleteMapping(value = "/usuario/{id}")
    public void borrarUsuario(@PathVariable("id") Long id){
        Usuario usuario =  usuarioRepository.getById(id);
        usuarioRepository.delete(usuario);
    }

    @PutMapping(value = "/usuario/{id}")
    public Usuario modificarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        Usuario user = usuarioRepository.getById(id);
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setDireccion(usuario.getDireccion());
        return usuarioRepository.save(user);
    }

    @PutMapping(value="/usuario/{id}/change")
    public Usuario modificarUsuarioCredenciales(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        Usuario user = usuarioRepository.getById(id);
        user.setPassword(usuario.pwd());
        user.setEmail(usuario.getEmail());
        return usuarioRepository.save(user);
    }

    @GetMapping(value = "/usuario/direccion")
    public List<Usuario> usuariosDeCiudad(@RequestParam String ciudad){
        return usuarioRepository.getByDireccionCiudad(ciudad);
    }

    @GetMapping(value = "/usuario/direccion/resistencia")
    public List<Usuario> usuariosDeResistencia(){
        return usuarioRepository.getByDireccionCiudad("Resistencia");
    }
}
