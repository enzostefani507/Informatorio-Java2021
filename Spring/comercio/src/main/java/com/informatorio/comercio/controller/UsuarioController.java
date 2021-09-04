package com.informatorio.comercio.controller;
import com.informatorio.comercio.domain.Usuario;
import com.informatorio.comercio.dto.UsuarioCredencialesDto;
import com.informatorio.comercio.repository.DireccionRepository;
import com.informatorio.comercio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController()
public class UsuarioController {

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(value = "/usuario")
    public Object crearUsuario(@RequestBody Usuario usuario){
        if (usuarioRepository.existsByEmail(usuario.getEmail())){
            return new ResponseEntity<>("Ya existe un usuario registrado con este email.",HttpStatus.CONFLICT);
        }else {
            return new ResponseEntity<> (usuarioRepository.save(usuario),HttpStatus.OK);
        }
    }

    @GetMapping(value = "/usuario")
    public List<Usuario> verUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping(value = "/usuario/{id}")
    public Object verUsuario(@PathVariable("id") Long id){
        Usuario usuario =  usuarioRepository.findById(id).orElse(null);
        if (usuario == null){
            return new ResponseEntity<>("El usuario con el id indicado no existe.",HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/usuario/{id}")
    public Object borrarUsuario(@PathVariable("id") Long id){
        Usuario usuario =  usuarioRepository.findById(id).orElse(null);
        if (usuario == null){
            return new ResponseEntity<>("No existe usuario con el id ingresado.",NOT_FOUND);
        }else{
            if (usuario.getOrdenes().size()>=1){
                usuario.setCambiarEstado();
                return new ResponseEntity<>("El usuario tiene compras registradas, pero ahora su cuenta esta inactiva.",HttpStatus.OK);
            }else{
                usuarioRepository.delete(usuario);
                return new ResponseEntity<>("El usuario fue eliminado.",HttpStatus.OK);
            }
        }
    }

    @PutMapping(value = "/usuario/{id}")
    public Object modificarUsuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario){
        Usuario user = usuarioRepository.findById(id).orElse(null);
        if (user == null){
            return new ResponseEntity<>("No existe usuario con el id ingresado.",NOT_FOUND);
        }else{
            user.setNombre(usuario.getNombre());
            user.setApellido(usuario.getApellido());
            user.setDireccion(usuario.getDireccion());
            return new ResponseEntity<>(usuarioRepository.save(user), HttpStatus.OK);
        }
    }

    @PutMapping(value="/usuario/{id}/credencial/contrasenia")
    public Object modificarUsuarioCredencialesPwd(@PathVariable("id") Long id,@RequestBody String contrasenia){
        Usuario user = usuarioRepository.findById(id).orElse(null);
        if (user == null){
            return new ResponseEntity<>("No existe usuario con el id ingresado.",NOT_FOUND);
        }else{
            user.setPassword(contrasenia);
            usuarioRepository.save(user);
            user = usuarioRepository.findById(id).orElse(null);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }
    }

    @PutMapping(value="/usuario/{id}/credencial/email")
    public Object modificarUsuarioCredencialesEmail(@PathVariable("id") Long id,@RequestBody String email){
        Usuario user = usuarioRepository.findById(id).orElse(null);
        if (user == null){
            return new ResponseEntity<>("No existe usuario con el id ingresado.",NOT_FOUND);
        }else{
            user.setEmail(email);
            usuarioRepository.save(user);
            user = usuarioRepository.findById(id).orElse(null);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }
    }

    @GetMapping(value = "/usuario/direccion")
    public List<Usuario> buscarUsuariosDeCiudad(@RequestParam String ciudad){
        return usuarioRepository.getByDireccionCiudad(ciudad);
    }

    @GetMapping(value = "/usuario/direccion/resistencia")
    public List<Usuario> buscarUsuariosDeResistencia(){
        return usuarioRepository.getByDireccionCiudad("Resistencia");
    }

    @GetMapping(value = "/usuario/buscar/fechaDesde")
    public List<Usuario> buscarUsuariosPorFechaAltaDede(@RequestParam  @DateTimeFormat(pattern = "dd.MM.yyyy") Date fecha){
        return usuarioRepository.getByFechaCreacionAfter(fecha);
    }

    @GetMapping(value = "/usuario/buscar/fechaCreacion")
    public List<Usuario> buscarUsuariosPorFecha(@RequestParam  @DateTimeFormat(pattern = "dd.MM.yyyy") Date fecha){
        return usuarioRepository.getByFechaCreacion(fecha);
    }
}
