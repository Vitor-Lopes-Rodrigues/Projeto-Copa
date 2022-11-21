package com.example.projetocopa.repositories;

import com.example.projetocopa.Models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    Usuario findUsuarioByNomeAndSenha(String nome, String senha);
    Usuario findById(Long id);
    Usuario findUsuariosByNome(String nome);

}
