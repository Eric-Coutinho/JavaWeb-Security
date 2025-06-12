package service;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import model.Usuarios;
import repository.UsuarioRepository;

public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean addUser(String nome, String email, String senha) {
        try {
            Usuarios usr = new Usuarios(nome, email, senha);
            usuarioRepository.save(usr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Usuarios verificaUser(String email, String senha) {
        Usuarios usr = usuarioRepository.findByEmailAndSenha(email, senha);
        if (usr != null)
            return usr;
        return null;
    }

    public int quantidadeUserCadastrado() {
        int quant = (int) usuarioRepository.count();
        return quant;
    }

    @PostConstruct
    public void init() {
        Usuarios adm = new Usuarios("adm", "adm", "adm");
        usuarioRepository.save(adm);
    }
}
