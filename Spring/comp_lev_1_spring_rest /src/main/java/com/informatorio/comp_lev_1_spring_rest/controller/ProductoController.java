package com.informatorio.comp_lev_1_spring_rest.controller;
import com.informatorio.comp_lev_1_spring_rest.repository.ProductoRepository;
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

import com.informatorio.comp_lev_1_spring_rest.domain.Producto;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository ProductoRepository;

    @GetMapping(value = "/{id}")
    public Optional<Producto> ver(@PathVariable Long id){
        return ProductoRepository.findById(id);
    }

    @GetMapping("")
    public List<Producto> listar(){
        return (List<Producto>) ProductoRepository.findAll();
    }

    @PostMapping("")
    public Producto insertar(@RequestBody Producto producto){
        return ProductoRepository.save(producto);
    }
     
    @PutMapping("")
    public void modificar(@RequestBody Producto producto){
        ProductoRepository.save(producto);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id){
        ProductoRepository.deleteById(id);
    }
}
