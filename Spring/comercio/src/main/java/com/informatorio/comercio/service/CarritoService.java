package com.informatorio.comercio.service;

import com.informatorio.comercio.domain.Carrito;
import com.informatorio.comercio.domain.Detalle;
import com.informatorio.comercio.domain.Producto;
import com.informatorio.comercio.domain.Usuario;
import com.informatorio.comercio.repository.CarritoRepository;
import com.informatorio.comercio.repository.DetalleRepository;
import com.informatorio.comercio.repository.ProductoRepository;
import com.informatorio.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static com.informatorio.comercio.service.DetalleService.generarDetalle;
import static com.informatorio.comercio.service.DetalleService.tratarExistenciaProductoEnCarrito;

@Service
public class CarritoService {
    @Autowired
    private static CarritoRepository carritoRepository;

    @Autowired
    private static UsuarioRepository usuarioRepository;

    @Autowired
    private static ProductoRepository productoRepository;

    @Autowired
    private static DetalleRepository detalleRepository;

    public static Date creacion(){
        return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    };

    public static Boolean nuevo_carrito(Usuario usuario){
        List<Carrito> carritos_del_user = usuario.getCarritos();
        if (carritos_del_user.size() >=1) {
            Carrito ultimo = carritos_del_user.get(carritos_del_user.size() - 1);
            ultimo.setEstado(false);
        }
        return true;
    }

    public static List<Detalle> evaluarCerrarCarrito(Carrito carrito){
        if (carrito.getDetalle().size()>=1) {
            carrito.setEstado(false);
            carritoRepository.save(carrito);
            return carrito.getDetalle();
        }
        return null;
    }

    public static void hacerCarritoComprado(Carrito carrito){
        carrito.setEstado(false);
        carritoRepository.save(carrito);
    }

    public static Detalle evaluarAnadirProducto(Carrito carrito, Long id_producto){
        if (carrito.getEstado()) {
            Producto producto = productoRepository.getById(id_producto);
            Detalle detalle = generarDetalle(producto, carrito);
            tratarExistenciaProductoEnCarrito(carrito, producto, detalle);
            return detalle;
        }
        return null;
    }

    public static Detalle evaluarDecrementarProducto(Carrito carrito, Long id_producto){
        if (carrito.getEstado()) {
            Producto producto = productoRepository.getById(id_producto);
            List<Detalle> detalles_del_carrito = carrito.getDetalle();
            for (Detalle d : detalles_del_carrito) {
                if (d.getProducto().getId().equals(producto.getId())) {
                    if (d.getCantidad() == 1) {
                        carrito.removeDetalle(d);
                        detalleRepository.save(d);
                        break;
                    } else {
                        d.decCantidad();
                        return detalleRepository.save(d);
                    }
                }
            }
        }
        return null;
    }

    public static Detalle evaluarIncrementarProducto(Carrito carrito, Long id_producto){
        if (carrito.getEstado()) {
            Producto producto = productoRepository.getById(id_producto);
            List<Detalle> detalles_del_carrito = carrito.getDetalle();
            for (Detalle d : detalles_del_carrito) {
                if (d.getProducto().getId().equals(producto.getId())) {
                    d.incCantidad();
                    return detalleRepository.save(d);
                }
            }
        }
        return null;
    }

    public static Detalle tratarSacarProducto(Carrito carrito, Long id_producto){
        if (carrito.getEstado()) {
            Producto producto = productoRepository.getById(id_producto);
            List<Detalle> detalles_del_carrito = carrito.getDetalle();
            for (Detalle d : detalles_del_carrito) {
                if (d.getProducto().getId().equals(producto.getId())) {
                    carrito.removeDetalle(d);
                    detalleRepository.delete(d);
                    return d;
                }
            }
        }
        return null;
    }
}
