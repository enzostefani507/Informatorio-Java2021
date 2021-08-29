package com.informatorio.comercio.service;

import com.informatorio.comercio.domain.Carrito;
import com.informatorio.comercio.domain.Detalle;
import com.informatorio.comercio.domain.Producto;
import com.informatorio.comercio.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleService {

    @Autowired
    private static CarritoRepository carritoRepository;

    public static Detalle generarDetalle(Producto producto, Carrito carrito){
        Detalle detalle = new Detalle();
        detalle.setProducto(producto);
        detalle.setCarrito(carrito);
        return detalle;
    }

    public static Detalle tratarExistenciaProductoEnCarrito(Carrito carrito, Producto producto,Detalle detalle){
        List<Detalle> detalles_del_carrito = carrito.getDetalle();
        for (Detalle d : detalles_del_carrito) {
            if (d.getProducto().equals(producto)) {
                return d;
            }
        }
        carrito.addDetalle(detalle);
        carritoRepository.save(carrito);
        return detalle;
    }
}
