package com.informatorio.comercio.controller;
import com.informatorio.comercio.domain.Usuario;
import com.informatorio.comercio.repository.DireccionRepository;
import com.informatorio.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.informatorio.comercio.service.UsuarioService.modificarCredenciales;
import static com.informatorio.comercio.service.UsuarioService.modificarDatos;

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
        return modificarDatos(user, usuario);
    }

    @PutMapping(value="/usuario/{id}/credencial")
    public Usuario modificarUsuarioCredenciales(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        Usuario user = usuarioRepository.getById(id);
        return modificarCredenciales(user, usuario);
    }

    @GetMapping(value = "/usuario/direccion")
    public List<Usuario> buscarUsuariosDeCiudad(@RequestParam String ciudad){
        return usuarioRepository.getByDireccionCiudad(ciudad);
    }

    @GetMapping(value = "/usuario/direccion/resistencia")
    public List<Usuario> buscarUsuariosDeResistencia(){
        return usuarioRepository.getByDireccionCiudad("Resistencia");
    }

    @GetMapping(value = "/usuario/buscar/fechaDesde")
    public List<Usuario> buscarUsuariosPorFechaAltaDede(@RequestParam  @DateTimeFormat(pattern = "dd.MM.yyyy") Date fecha){
        return usuarioRepository.getByFechaCreacionAfter(fecha);
    }

    @GetMapping(value = "/usuario/buscar/fechaCreacion")
    public List<Usuario> buscarUsuariosPorFecha(@RequestParam  @DateTimeFormat(pattern = "dd.MM.yyyy") Date fecha){
        return usuarioRepository.getByFechaCreacion(fecha);
    }
}
