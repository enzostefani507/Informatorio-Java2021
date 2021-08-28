package com.informatorio.comercio.repository;
import com.informatorio.comercio.domain.Categoria;
import com.informatorio.comercio.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Producto getById(Long id);
    List<Producto> findByNombreStartingWith(String nombre);
    List<Producto> findByCategoria(Categoria categoria);
    List<Producto> findByNombreContaining(String nombre);
}
