package com.example.projetocopa.repositories;

import com.example.projetocopa.Models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    Usuario findUsuarioByLoginAndSenha(String login, String senha);
    Usuario findByLogin(String login);

}
