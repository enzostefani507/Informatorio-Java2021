package com.informatorio.comercio.service;

import com.informatorio.comercio.domain.Usuario;
import com.informatorio.comercio.dto.UsuarioCredencialesDto;
import com.informatorio.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class UsuarioService {

    @Autowired
    private static UsuarioRepository usuarioRepository;

    public static Date creacion(){
        return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    };

}
