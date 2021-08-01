package com.informatorio.comp_lev_1_spring_rest.controller;
import com.informatorio.comp_lev_1_spring_rest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.informatorio.comp_lev_1_spring_rest.domain.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/{id}")
    public Optional<Usuario> ver(@PathVariable Long id){
        return usuarioRepository.findById(id);
    }

    @GetMapping("")
    public List<Usuario> listar(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @PostMapping("")
    public void insertar(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }
     
    @PutMapping("")
    public void modificar(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioRepository.deleteById(id);
    }
}
