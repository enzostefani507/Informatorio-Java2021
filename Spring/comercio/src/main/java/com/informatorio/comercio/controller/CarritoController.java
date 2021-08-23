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

import static com.informatorio.comercio.service.CarritoService.nuevo_carrito;


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

    @GetMapping(value = "/carrito/{id}")
    public Carrito verCarrito(@PathVariable("id") Long id){
        return carritoRepository.getById(id);
    }

    @DeleteMapping(value = "/carrito/{id}")
    public void borrarCarrito(@PathVariable("id") Long id){
        carritoRepository.deleteById(id);
    }

    @PutMapping(value = "/carrito/{id_carrito}/addproducto/{id_producto}")
    public Carrito addProducto(@PathVariable("id_carrito") Long id_carrito,@PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.getById(id_carrito);
        Producto producto = productoRepository.getById(id_producto);
        Detalle detalle = new Detalle();
        detalle.setProducto(producto);
        detalle.setCarrito(carrito);
        Boolean producto_existente = false;
        List<Detalle> detalles_del_carrito = carrito.getDetalle();
        for (Detalle d: detalles_del_carrito ){
            if (d.getProducto().equals(producto)){
                producto_existente = true;
                break;
            }
        }
        if (!producto_existente) {
            carrito.addDetalle(detalle);
        }
        carritoRepository.save(carrito);
        return carrito;
    }

    @PutMapping(value = "/carrito/{id_carrito}/decproducto/{id_producto}")
    public Carrito decremetarProducto(@PathVariable("id_carrito") Long id_carrito, @PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.getById(id_carrito);
        Producto producto = productoRepository.getById(id_producto);
        List<Detalle> detalles_del_carrito = carrito.getDetalle();
        for (Detalle d: detalles_del_carrito ){
            if (d.getProducto().equals(producto)){
                if (d.getCantidad()==1){
                    carrito.removeDetalle(d);
                    detalleRepository.save(d);
                }else {
                    d.decCantidad(1);
                    break;
                }

            }
        }
        carritoRepository.save(carrito);
        return carrito;
    }

    @PutMapping(value = "/carrito/{id_carrito}/incproducto/{id_producto}")
    public Carrito incremetarProducto(@PathVariable("id_carrito") Long id_carrito, @PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.getById(id_carrito);
        Producto producto = productoRepository.getById(id_producto);
        List<Detalle> detalles_del_carrito = carrito.getDetalle();
        for (Detalle d: detalles_del_carrito ){
            if (d.getProducto().equals(producto)){
                d.incCantidad(1);
                detalleRepository.save(d);
                carritoRepository.save(carrito);
            }
        }
        return carrito;
    }

    @PutMapping(value = "/carrito/{id_carrito}/delproducto/{id_producto}")
    public Carrito delProducto(@PathVariable("id_carrito") Long id_carrito, @PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.getById(id_carrito);
        Producto producto = productoRepository.getById(id_producto);
        List<Detalle> detalles_del_carrito = carrito.getDetalle();
        for (Detalle d: detalles_del_carrito ){
            if (d.getProducto().equals(producto)){
                carrito.removeDetalle(d);
                detalleRepository.delete(d);
                break;
            }
        }
        carritoRepository.save(carrito);
        return carrito;
    }
}
