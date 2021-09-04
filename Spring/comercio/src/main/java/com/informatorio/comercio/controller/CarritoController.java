package com.informatorio.comercio.controller;

import com.informatorio.comercio.domain.*;
import com.informatorio.comercio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.informatorio.comercio.service.CarritoService.*;
import static com.informatorio.comercio.service.DetalleService.generarDetalle;
import static com.informatorio.comercio.service.DetalleService.tratarExistenciaProductoEnCarrito;


@RestController
public class CarritoController {

    @Autowired
    private DetalleRepository detalleRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping(value = "/usuario/{id_usuario}/carrito")
    public Object crearCarrito(@PathVariable("id_usuario") Long id_usuario, @RequestBody Carrito carrito){
        Usuario user = usuarioRepository.findById(id_usuario).orElse(null);
        if (user == null) {
            return new ResponseEntity<>("El usuario con el id indicado no existe.", HttpStatus.NOT_FOUND);
        }else {
            carrito.setUsuario(user);
            //nuevo_carrito(user);
            List<Carrito> carritos_del_user = user.getCarritos();
            if (carritos_del_user.size() >=1) {
                Carrito ultimo = carritos_del_user.get(carritos_del_user.size() - 1);
                if (ultimo.getEstado()){
                    return new ResponseEntity<> ("No puede crear otro, ya tiene un carrito abierto",HttpStatus.CREATED);
                }else {
                    ultimo.setEstado(false);
                    return new ResponseEntity<> (carritoRepository.save(carrito),HttpStatus.CREATED);
                }
            }else{
                return new ResponseEntity<> (carritoRepository.save(carrito),HttpStatus.CREATED);
            }
        }
    }

    @GetMapping(value = "/carrito")
    public List<Carrito> verCarritos(){
        return carritoRepository.findAll();
    }

    @GetMapping(value = "/carrito/{id_carrito}")
    public Object verCarrito(@PathVariable("id_carrito") Long id_carrito){
        Carrito carrito = carritoRepository.findById(id_carrito).orElse(null);
        if (carrito == null){
            return new ResponseEntity<>("El carrito con el id indicado no existe.", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(carrito, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/carrito/{id_carrito}/estado")
    public Object cerrarCarrito(@PathVariable("id_carrito") Long id_carrito){
        Carrito carrito = carritoRepository.findById(id_carrito).orElse(null);
        if (carrito == null){
            return new ResponseEntity<>("El carrito con el id indicado no existe.", HttpStatus.NOT_FOUND);
        }else {
            //return evaluarCerrarCarrito(carrito);
            if (carrito.getDetalle().size()>=1) {
                carrito.setEstado(false);
                carritoRepository.save(carrito);
                return new ResponseEntity<> (carrito.getDetalle(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Su carrito no tiene productos, no se puede cerrar",HttpStatus.CONFLICT);
            }
        }
    }

    @DeleteMapping(value = "/carrito/{id_carrito}")
    public Object borrarCarrito(@PathVariable("id_carrito") Long id_carrito){
        Carrito carrito = carritoRepository.findById(id_carrito).orElse(null);
        if (carrito == null){
            return new ResponseEntity<>("El carrito con el id indicado no existe.", HttpStatus.NOT_FOUND);
        }else{
            List<Orden> orden_list = ordenRepository.findAll();
            for ( Orden o: orden_list) {
                if (o.getId().equals(carrito.getId())) {
                    return new ResponseEntity<>("El carrito no se borro, esta asociado con una compra.", HttpStatus.CONFLICT);
                }
            }
            carritoRepository.delete(carrito);
            return new ResponseEntity<>("El carrito se borro",HttpStatus.OK);
        }
    }

    @PutMapping(value = "/carrito/{id_carrito}/producto/{id_producto}")
    public Object addProducto(@PathVariable("id_carrito") Long id_carrito,@PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.findById(id_carrito).orElse(null);
        if (carrito == null){
            return new ResponseEntity<>("El carrito con el id indicado no existe.", HttpStatus.NOT_FOUND);
        }else {
            if (carrito.getEstado()) {
                Producto producto = productoRepository.findById(id_producto).orElse(null);
                if (producto != null) {
                    //Detalle detalle = generarDetalle(producto, carrito);
                    Detalle detalle = new Detalle();
                    detalle.setProducto(producto);
                    detalle.setCarrito(carrito);
                    //tratarExistenciaProductoEnCarrito(carrito, producto, detalle);
                    List<Detalle> detalles_del_carrito = carrito.getDetalle();
                    for (Detalle d : detalles_del_carrito) {
                        if (d.getProducto().equals(producto)) {
                            return new ResponseEntity<> ("El producto con el id ingresado ya esta en tu carrito",HttpStatus.CONFLICT);
                        }
                    }
                    carrito.addDetalle(detalle);
                    carritoRepository.save(carrito);
                    return detalle;
                }else{
                    return new ResponseEntity<> ("No existe el producto con el id ingresado",HttpStatus.CONFLICT);
                }
            }else{
                return new ResponseEntity<> ("No se puede añadir, el carrito esta cerrado",HttpStatus.CONFLICT);
            }
        }
    }

    @PutMapping(value = "/carrito/{id_carrito}/producto/{id_producto}/resta")
    public Object decremetarProducto(@PathVariable("id_carrito") Long id_carrito, @PathVariable("id_producto") Long id_producto) {
        Carrito carrito = carritoRepository.findById(id_carrito).orElse(null);
        //evaluarDecrementarProducto(carrito, id_producto);
        if (carrito != null) {
            if (carrito.getEstado()) {
                Producto producto = productoRepository.findById(id_producto).orElse(null);
                if (producto != null) {
                    List<Detalle> detalles_del_carrito = carrito.getDetalle();
                    for (Detalle d : detalles_del_carrito) {
                        if (d.getProducto().getId().equals(producto.getId())) {
                            if (d.getCantidad() == 1) {
                                carrito.removeDetalle(d);
                                detalleRepository.save(d);
                                return new ResponseEntity<>("Producto eliminado del carrito", HttpStatus.OK);
                            } else {
                                d.decCantidad();
                                detalleRepository.save(d);
                                return new ResponseEntity<>(d, HttpStatus.OK);
                            }
                        }
                    }
                    return new ResponseEntity<>("No se encontro el producto", HttpStatus.CONFLICT);
                }else{
                    return new ResponseEntity<>("No existe producto con el id indicado",HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>("No se modificar el carrito, el carrito esta cerrado", HttpStatus.CONFLICT);
            }
        }else{
            return new ResponseEntity<>("No se carrito con el id indicado", HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/carrito/{id_carrito}/producto/{id_producto}/suma")
    public Object incremetarProducto(@PathVariable("id_carrito") Long id_carrito, @PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.findById(id_carrito).orElse(null);
        if (carrito != null) {
            if (carrito.getEstado()) {
                Producto producto = productoRepository.findById(id_producto).orElse(null);
                if (producto != null) {
                    List<Detalle> detalles_del_carrito = carrito.getDetalle();
                    for (Detalle d : detalles_del_carrito) {
                        if (d.getProducto().getId().equals(producto.getId())) {
                            d.incCantidad();
                            return new ResponseEntity<>(detalleRepository.save(d), HttpStatus.CREATED);
                        }
                    }
                }else{
                    return new ResponseEntity<>("No existe producto con el id indicado", HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>("Este carrito esta cerrado", HttpStatus.CONFLICT);
            }
        }else{
            return new ResponseEntity<>("No existe carrito con el id indicado", HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @PutMapping(value = "/carrito/{id_carrito}/producto/{id_producto}/baja")
    public Object delProducto(@PathVariable("id_carrito") Long id_carrito, @PathVariable("id_producto") Long id_producto){
        Carrito carrito = carritoRepository.findById(id_carrito).orElse(null);
        if (carrito != null) {
            if (carrito.getEstado()) {
                Producto producto = productoRepository.findById(id_producto).orElse(null);
                if (producto != null) {
                    List<Detalle> detalles_del_carrito = carrito.getDetalle();
                    for (Detalle d : detalles_del_carrito) {
                        if (d.getProducto().getId().equals(producto.getId())) {
                            carrito.removeDetalle(d);
                            detalleRepository.delete(d);
                            return new ResponseEntity<>("Se removio el producto del carrito", HttpStatus.OK);
                        }
                    }
                    return new ResponseEntity<>("No existe este producto en tu carrito", HttpStatus.NOT_FOUND);
                }else{
                    return new ResponseEntity<>("No existe producto con el id indicado", HttpStatus.NOT_FOUND);
                }
            }else{
                return new ResponseEntity<>("Este carrito esta cerrado", HttpStatus.CONFLICT);
            }
        }else{
            return new ResponseEntity<>("No existe carrito con el id indicado", HttpStatus.NOT_FOUND);
        }
    }
}
