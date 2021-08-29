package com.informatorio.comercio.service;

import com.informatorio.comercio.domain.Producto;
import com.informatorio.comercio.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private static ProductoRepository productoRepository;

    public static Producto modificarDatosProducto(Producto prod, Producto producto){
        prod.setDescripcion(producto.getDescripcion());
        prod.setNombre(producto.getNombre());
        prod.setPrecio_unitario(producto.getPrecio_unitario());
        prod.setContenido(producto.getContenido());
        prod.setPublicado(producto.getPublicado());
        prod.setCategoria(producto.getCategoria());
        prod.setCodigo_inventario(producto.getCodigo_inventario());
        return productoRepository.save(prod);
    }
}
