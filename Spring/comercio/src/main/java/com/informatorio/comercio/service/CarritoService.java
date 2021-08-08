package com.informatorio.comercio.service;

import com.informatorio.comercio.domain.Carrito;
import com.informatorio.comercio.domain.Usuario;
import com.informatorio.comercio.repository.CarritoRepository;
import com.informatorio.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class CarritoService {
    @Autowired
    private static CarritoRepository carritoRepository;

    @Autowired
    private static UsuarioRepository usuarioRepository;

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
}
