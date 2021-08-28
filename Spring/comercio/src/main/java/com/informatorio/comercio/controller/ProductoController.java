package com.informatorio.comercio.controller;
import com.informatorio.comercio.domain.Categoria;
import com.informatorio.comercio.domain.Producto;
import com.informatorio.comercio.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping(value = "/producto")
    public Producto crearProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @GetMapping(value = "/producto")
    public List<Producto> verProductos(){
        return  productoRepository.findAll();
    }

    @GetMapping(value = "/producto/{id}")
    public Producto verProducto(@PathVariable("id") Long id){
        return productoRepository.getById(id);
    }

    @GetMapping(value = "/producto/buscar/nombre/exact")
    public List<Producto> buscarPorNombre(@RequestParam(value="nombre") String nombre){
        return productoRepository.findByNombreStartingWith(nombre);
    }

    @PutMapping(value = "/producto/{id}")
    public Producto modificarProducto(@PathVariable("id") Long id, @RequestBody  Producto producto){
        Producto prod = productoRepository.getById(id);
        prod.setDescripcion(producto.getDescripcion());
        prod.setNombre(producto.getNombre());
        prod.setPrecio_unitario(producto.getPrecio_unitario());
        prod.setContenido(producto.getContenido());
        prod.setPublicado(producto.getPublicado());
        prod.setCategoria(producto.getCategoria());
        prod.setCodigo_inventario(producto.getCodigo_inventario());
        return productoRepository.save(prod);
    }

    @GetMapping(value = "/producto/buscaC/")
    public List<Producto> buscarPorCategoria(@RequestParam(value="categoria") Categoria categoria){
        return productoRepository.findByCategoria(categoria);
    }

    @DeleteMapping(value = "producto/{id}")
    public void borrarProducto(@PathVariable("id") Long id){
        Producto producto = productoRepository.getById(id);
        productoRepository.delete(producto);
    }

    @GetMapping(value = "producto/buscar/nombre/aprox")
    public List<Producto> buscarProductoPorCadenaContenidaEnNombre(@RequestParam String nombre){
        return productoRepository.findByNombreContaining(nombre);
    }


    @GetMapping(value = "producto/NoPublicado")
    public List<Producto> buscarProductoNoPublicados(){
        return productoRepository.findByPublicadoFalse();
    }

    @GetMapping(value = "producto/SiPublicado")
    public List<Producto> buscarProductoSiPublicados(){
        return productoRepository.findByPublicadoTrue();
    }
}
