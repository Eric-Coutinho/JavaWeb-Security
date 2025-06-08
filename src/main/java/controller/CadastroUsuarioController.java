package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Usuario;
import service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroUsuarioController {
    @GetMapping("/cadastroUsuario")
    public String form() {
        return "cadastroUsuario";
    }

    @PostMapping("/cadastroUsuario")
    public String cadastroUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        boolean sucesso = UsuarioService.cadastrarUsuario(usuario);
        return sucesso ? "redirect:/login" : "cadastroUsuario";
    }    
}
