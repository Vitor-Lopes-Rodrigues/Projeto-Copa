package com.example.projetocopa.security;

import com.example.projetocopa.Models.Usuario;
import com.example.projetocopa.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ImplementsUserDetailService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario não encontrado!");
        }
        return new User(usuario.getUsername(), usuario.getPassword(), true, true,
                true, true, usuario.getAuthorities());
    }
}
