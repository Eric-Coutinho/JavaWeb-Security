package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        UsuarioService usuarioService = new UsuarioService();
        boolean sucesso = usuarioService.addUser(nome, email, senha);
        return sucesso ? "redirect:/login" : "cadastroUsuario";
    }    
}
