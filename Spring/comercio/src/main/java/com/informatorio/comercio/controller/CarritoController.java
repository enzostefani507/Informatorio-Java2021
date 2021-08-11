package com.informatorio.comercio.controller;

import com.informatorio.comercio.domain.Carrito;
import com.informatorio.comercio.domain.Producto;
import com.informatorio.comercio.domain.Usuario;
import com.informatorio.comercio.repository.CarritoRepository;
import com.informatorio.comercio.repository.ProductoRepository;
import com.informatorio.comercio.repository.UsuarioRepository;
import com.informatorio.comercio.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.informatorio.comercio.service.CarritoService.nuevo_carrito;


@RestController
public class CarritoController {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping(value = "/carrito/nuevo/{id}")
    public Carrito crearCarrito(@PathVariable("id") Long id){
        Carrito carr = new Carrito();
        Usuario user = usuarioRepository.getById(id);
        carr.setUsuario(user);
        nuevo_carrito(user);
        return carritoRepository.save(carr);
    }
    @GetMapping(value = "/carrito")
    public List<Carrito> verCarritos(){
        return carritoRepository.findAll();
    }

    @DeleteMapping(value = "/carrito/{id}")
    public void borrarCarrito(@PathVariable("id") Long id){
        carritoRepository.deleteById(id);
    }

    @PutMapping(value = "/carrito/{id_carrito}/producto/{id_producto}")
    public Carrito addProducto(@PathVariable("id_carrito") Long id_carrito,@PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.getById(id_carrito);
        List<Producto> productos = carrito.getProductos();
        Producto producto = productoRepository.getById(id_producto);
        if (!productos.contains(producto)){
            carrito.addProducto(producto);
            carritoRepository.save(carrito);
        }
        return carrito;
    }

    @PutMapping(value = "/carrito/{id_carrito}/producto/{id_producto}")
    public void removeProducto(@PathVariable("id_carrito") Long id_carrito,@PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.getById(id_carrito);
        Producto producto = productoRepository.getById(id_producto);
        carrito.removeProducto(producto);
        carritoRepository.save(carrito);
    }
}
