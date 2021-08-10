package com.informatorio.comp_lev_1_spring_rest.controller;
import com.informatorio.comp_lev_1_spring_rest.repository.ProductoRepository;
import com.informatorio.comp_lev_1_spring_rest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.informatorio.comp_lev_1_spring_rest.domain.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/",params="id")
    public Optional<Usuario> ver(@RequestParam Long id){
        return usuarioRepository.findById(id);
    }

    @GetMapping("")
    public List<Usuario> listar(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @PostMapping("")
    public Usuario insertar(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping("")
    public Usuario modificar(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioRepository.deleteById(id);
    }
}
