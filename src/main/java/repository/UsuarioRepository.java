package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long>{
    Usuarios findByEmailAndSenha(String email, String senha);

    Usuarios findByEmail(String email);
}
