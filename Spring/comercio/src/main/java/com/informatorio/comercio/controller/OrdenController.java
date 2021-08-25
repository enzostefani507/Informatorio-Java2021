package com.informatorio.comercio.controller;

import com.informatorio.comercio.domain.Orden;
import com.informatorio.comercio.domain.Producto;
import com.informatorio.comercio.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdenController {
    @Autowired
    private OrdenRepository ordenRepository;

    @GetMapping(value = "/orden")
    public List<Orden> verOrdenes(){
        return  ordenRepository.findAll();
    }

    @GetMapping(value = "/orden/{id}")
    public Orden verOrden(@PathVariable("id") Long id){
        return ordenRepository.getById(id);
    }
}