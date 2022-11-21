package com.example.projetocopa.security;

import com.example.projetocopa.Models.Usuario;
import com.example.projetocopa.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ImplementsUserDetailService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findUsuariosByNome(nome);

        if (usuario == null)
            throw new UsernameNotFoundException("Usuario nao encontrado");
        return usuario;
    }
}
