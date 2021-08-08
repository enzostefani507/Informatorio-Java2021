package com.informatorio.comercio.controller;

import com.informatorio.comercio.domain.Carrito;
import com.informatorio.comercio.domain.Usuario;
import com.informatorio.comercio.repository.CarritoRepository;
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

    @PostMapping(value = "/usuario/{id}/carrito")
    public Carrito crearCarrito(@PathVariable("id") Long id, @RequestBody Carrito carrito){
        Usuario user = usuarioRepository.getById(id);
        carrito.setUsuario(user);
        nuevo_carrito(user);
        return carritoRepository.save(carrito);
    }
    @GetMapping(value = "/carrito")
    public List<Carrito> verCarritos(){
        return carritoRepository.findAll();
    }

    @DeleteMapping(value = "/carrito/{id}")
    public void borrarCarrito(@PathVariable("id") Long id){
        carritoRepository.deleteById(id);
    }
}
