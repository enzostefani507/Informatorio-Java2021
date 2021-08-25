package com.informatorio.comercio.controller;

import com.informatorio.comercio.domain.*;
import com.informatorio.comercio.repository.CarritoRepository;
import com.informatorio.comercio.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.informatorio.comercio.domain.Estado.Confirmada;

@RestController
public class OrdenController {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @GetMapping(value = "/orden")
    public List<Orden> verOrdenes(){
        return  ordenRepository.findAll();
    }

    @GetMapping(value = "/orden/{id}")
    public Orden verOrden(@PathVariable("id") Long id){
        return ordenRepository.getById(id);
    }

    @PostMapping(value = "/ordenadd/{id_carrito}")
    public Orden crearOrden(@PathVariable("id_carrito") Long id_carrito,@RequestBody Orden orden){
        Carrito carrito = carritoRepository.getById(id_carrito);
        if (carrito.getEstado()) {
            orden.setCarrito_id(id_carrito);
            orden.setEstado(Confirmada);
            orden.setUsuario(carrito.getUsuario());
            List<Detalle> detalles_del_carrito = carrito.getDetalle();
            for  (Detalle d : detalles_del_carrito) {
                Linea l = new Linea();
                l.setProducto_id(d.getProducto().getId());
                l.setCantidad(d.getCantidad());
                l.setPrecio(d.getProducto().getPrecio_unitario());
                l.setOrden(orden);
                orden.addLinea(l);
                ordenRepository.save(orden);
            }
            carrito.setEstado(false);
            carritoRepository.save(carrito);
            return ordenRepository.save(orden);
        }
        return null;
    }
}