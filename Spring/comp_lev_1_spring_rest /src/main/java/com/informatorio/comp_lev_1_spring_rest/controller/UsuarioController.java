package main.java.com.informatorio.comp_lev_1_spring_rest.controller;
import com.informatorio.comp_lev_1_spring_rest.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    @GetMapping("")
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
}
