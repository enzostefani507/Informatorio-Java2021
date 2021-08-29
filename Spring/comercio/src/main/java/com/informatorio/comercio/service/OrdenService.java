package com.informatorio.comercio.service;

import com.informatorio.comercio.domain.*;
import com.informatorio.comercio.repository.CarritoRepository;
import com.informatorio.comercio.repository.OrdenRepository;
import com.informatorio.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static com.informatorio.comercio.domain.Estado.Cancelada;
import static com.informatorio.comercio.domain.Estado.Confirmada;
import static com.informatorio.comercio.domain.Rol.Comerciante;
import static com.informatorio.comercio.service.CarritoService.hacerCarritoComprado;
import static com.informatorio.comercio.service.LineaService.crearLinea;

@Service
public class OrdenService {

    @Autowired
    private static CarritoRepository carritoRepository;

    @Autowired
    private static OrdenRepository ordenRepository;

    @Autowired
    private static UsuarioRepository usuarioRepository;

    public static Long generarNumeroFactura(Carrito carrito) {
        Random random = new Random();
        Long numero = carrito.getUsuario().getId()*carrito.getId()*random.nextInt();
        return numero;
    }

    public static void cargarLineas(Carrito carrito, Orden orden){
        List<Detalle> detalles_del_carrito = carrito.getDetalle();
        for  (Detalle d : detalles_del_carrito) {
            orden.addLinea(crearLinea(d,orden));
            ordenRepository.save(orden);
        }
    }

    public static Orden tratarCreacionOrden(Orden orden,Long id_carrito){
        Carrito carrito = carritoRepository.getById(id_carrito);
        if (carrito.getEstado() && (carrito.getDetalle().size()>=1)) {
            orden.setCarrito_id(id_carrito);
            orden.setEstado(Confirmada);
            orden.setUsuario(carrito.getUsuario());
            orden.setObservacion(orden.getObservacion());
            orden.setNumero(generarNumeroFactura(carrito));
            cargarLineas(carrito,orden);
            hacerCarritoComprado(carrito);
            return ordenRepository.save(orden);
        }
        return null;
    }

    public static Orden tratarCancelarOrden(Orden orden, Long id_usuario){
        Usuario usuario = usuarioRepository.getById(id_usuario);
        if ((usuario.getRol()==Comerciante) && (orden.getEstado()==Confirmada)){
            orden.setEstado(Cancelada);
            return ordenRepository.save(orden);
        }
        return null;
    }

}
