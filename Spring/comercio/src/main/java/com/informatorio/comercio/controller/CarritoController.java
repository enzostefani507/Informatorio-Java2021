package com.informatorio.comercio.controller;

import com.informatorio.comercio.domain.Carrito;
import com.informatorio.comercio.domain.Detalle;
import com.informatorio.comercio.domain.Producto;
import com.informatorio.comercio.domain.Usuario;
import com.informatorio.comercio.repository.CarritoRepository;
import com.informatorio.comercio.repository.DetalleRepository;
import com.informatorio.comercio.repository.ProductoRepository;
import com.informatorio.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.informatorio.comercio.service.CarritoService.*;


@RestController
public class CarritoController {

    @Autowired
    private DetalleRepository detalleRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping(value = "/usuario/{id_usuario}/carrito")
    public Carrito crearCarrito(@PathVariable("id_usuario") Long id_usuario, @RequestBody Carrito carrito){
        Usuario user = usuarioRepository.getById(id_usuario);
        carrito.setUsuario(user);
        nuevo_carrito(user);
        return carritoRepository.save(carrito);
    }

    @GetMapping(value = "/carrito")
    public List<Carrito> verCarritos(){
        return carritoRepository.findAll();
    }

    @GetMapping(value = "/carrito/{id_carrito}")
    public Carrito verCarrito(@PathVariable("id_carrito") Long id_carrito){
        return carritoRepository.getById(id_carrito);
    }

    @PutMapping(value = "/carrito/{id_carrito}/estado")
    public List<Detalle> cerrarCarrito(@PathVariable("id_carrito") Long id_carrito){
        Carrito carrito = carritoRepository.getById(id_carrito);
        evaluarCerrarCarrito(carrito);
        return null;
    }

    @DeleteMapping(value = "/carrito/{id_carrito}")
    public void borrarCarrito(@PathVariable("id_carrito") Long id_carrito){
        carritoRepository.deleteById(id_carrito);
    }

    @PutMapping(value = "/carrito/{id_carrito}/producto/{id_producto}")
    public Detalle addProducto(@PathVariable("id_carrito") Long id_carrito,@PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.getById(id_carrito);
        evaluarAnadirProducto(carrito,id_producto);
        return null;
    }

    @PutMapping(value = "/carrito/{id_carrito}/producto/{id_producto}/resta")
    public Detalle decremetarProducto(@PathVariable("id_carrito") Long id_carrito, @PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.getById(id_carrito);
        evaluarDecrementarProducto(carrito, id_producto);
        return null;
    }

    @PutMapping(value = "/carrito/{id_carrito}/producto/{id_producto}/suma")
    public Detalle incremetarProducto(@PathVariable("id_carrito") Long id_carrito, @PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.getById(id_carrito);
        evaluarIncrementarProducto(carrito, id_producto);
        return null;
    }

    @PutMapping(value = "/carrito/{id_carrito}/producto/{id_producto}/baja")
    public Detalle delProducto(@PathVariable("id_carrito") Long id_carrito, @PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.getById(id_carrito);
        tratarSacarProducto(carrito,id_producto);
        return null;
    }
}
