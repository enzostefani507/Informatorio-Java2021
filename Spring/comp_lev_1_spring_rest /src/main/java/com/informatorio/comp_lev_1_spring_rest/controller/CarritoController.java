package com.informatorio.comp_lev_1_spring_rest.controller;
import com.informatorio.comp_lev_1_spring_rest.repository.CarritoRepository;
import com.informatorio.comp_lev_1_spring_rest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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

import com.informatorio.comp_lev_1_spring_rest.domain.Carrito;
import com.informatorio.comp_lev_1_spring_rest.domain.Producto;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoRepository carritoRepository;

    @GetMapping(value = "/{id}")
    public Optional<Carrito> ver(@PathVariable Long id){
        return carritoRepository.findById(id);
    }

    @GetMapping("")
    public List<Carrito> listar(){
        return (List<Carrito>) carritoRepository.findAll();
    }

    @PostMapping("")
    public void insertar(@RequestBody Carrito carrito){
        carritoRepository.save(carrito);
    }

    @PutMapping(value = "/{id}")
    public Carrito addProducto(@PathVariable Long id, Producto producto) {
        Carrito carritoActual = carritoRepository.findById(id).get();
        carritoActual.addProducto(producto);
        return carritoRepository.save(carritoActual);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable Long id){
        carritoRepository.deleteById(id);
    }
}
