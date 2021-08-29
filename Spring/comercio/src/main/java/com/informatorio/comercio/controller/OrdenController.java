package com.informatorio.comercio.controller;

import com.informatorio.comercio.domain.*;
import com.informatorio.comercio.repository.CarritoRepository;
import com.informatorio.comercio.repository.OrdenRepository;
import com.informatorio.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

import static com.informatorio.comercio.domain.Estado.Cancelada;
import static com.informatorio.comercio.domain.Estado.Confirmada;
import static com.informatorio.comercio.domain.Rol.Comerciante;
import static com.informatorio.comercio.service.OrdenService.tratarCancelarOrden;
import static com.informatorio.comercio.service.OrdenService.tratarCreacionOrden;
import static java.lang.Math.random;

@RestController
public class OrdenController {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/orden")
    public List<Orden> verOrdenes(){
        return  ordenRepository.findAll();
    }

    @GetMapping(value = "/orden/{id_orden}")
    public Orden verOrden(@PathVariable("id_orden") Long id_orden){
        return ordenRepository.getById(id_orden);
    }

    @PostMapping(value = "/orden/{id_carrito}")
    public Orden crearOrden(@PathVariable("id_carrito") Long id_carrito,@RequestBody Orden orden){
        tratarCreacionOrden(orden, id_carrito);
        return null;
    }

    @PutMapping(value = "usuario/{id_usuario}/orden/{id_carrito}/close")
    public Orden cancelarOrden(@PathVariable("id_carrito") Long id_carrito, @PathVariable("id_usuario") Long id_usuario){
        Orden orden = ordenRepository.getById(id_carrito);
        tratarCancelarOrden(orden, id_usuario);
        return null;
    }

    @DeleteMapping(value = "/orden/{id_orden}")
    public void borrarOrden(@PathVariable("id_orden") Long id_orden){
        Orden orden =  ordenRepository.getById(id_orden);
        ordenRepository.delete(orden);
    }

    @GetMapping(value = "/usuario/{id_usuario}/orden")
    public List<Orden> obtenerOrdenesDelUsuario(@PathVariable("id_usuario") Long id_usuario){
        Usuario user = usuarioRepository.getById(id_usuario);
        return ordenRepository.findByUsuario(user);
    }

}