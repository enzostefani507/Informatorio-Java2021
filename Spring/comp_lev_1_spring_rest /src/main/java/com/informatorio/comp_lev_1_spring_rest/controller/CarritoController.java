package com.informatorio.comp_lev_1_spring_rest.controller;
import com.informatorio.comp_lev_1_spring_rest.domain.Usuario;
import com.informatorio.comp_lev_1_spring_rest.repository.CarritoRepository;
import com.informatorio.comp_lev_1_spring_rest.repository.ProductoRepository;
import com.informatorio.comp_lev_1_spring_rest.domain.Producto;
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

import java.util.Optional;

import com.informatorio.comp_lev_1_spring_rest.domain.Carrito;

@RestController
public class CarritoController {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping(value = "/carrito/{id}")
    public Optional<Carrito> ver(@PathVariable Long id){
        Optional<Carrito> carrito = carritoRepository.findById(id);
        return carrito;
    }

    @GetMapping("/carrito")
    public Iterable<Carrito> listar(){
        return carritoRepository.findAll();
    }

    @PostMapping("")
    @RequestMapping("/usuario/{id}/carrito")
    public Carrito insertar(@PathVariable Long id, @RequestBody Carrito carrito){
        Usuario usuario = usuarioRepository.findById(id).get();
        carrito.setUsuario(usuario);
        return carritoRepository.save(carrito);
    }
    
    @PutMapping(value = "/usuario/{id}/carrito/{carritoId}/producto/{productoId}")
    public Carrito addProducto(@PathVariable Long id, @PathVariable long carritoId, @PathVariable long productoId) {
        Carrito carrito = carritoRepository.findById(carritoId).get();
        Producto producto = productoRepository.findById(productoId).get();
        carrito.addProducto(producto);
        return carritoRepository.save(carrito);
    }

    @DeleteMapping(value = "/carrito/{id}")
    public void eliminar(@PathVariable Long id){
        carritoRepository.deleteById(id);
    }
}
