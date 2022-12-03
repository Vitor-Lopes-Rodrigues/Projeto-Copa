package com.example.projetocopa.Services;

import com.example.projetocopa.Models.Role;
import com.example.projetocopa.Models.Usuario;
import com.example.projetocopa.repositories.RoleRepository;
import com.example.projetocopa.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    RoleRepository roleRepository;

    public List<Usuario> buscaUsuarios(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public void adicionar(Usuario usuario, boolean admin){
        List<Role> roles = new ArrayList<>();
        if(admin){
            roles.add(roleRepository.findByNomeRole("ROLE_ADMIN"));
            usuario.setRoles(roles);
        }else{
            roles.add(roleRepository.findByNomeRole("ROLE_USER"));
            usuario.setRoles(roles);
        }
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
    }

    public void deletar(String login){
        Usuario usuario = usuarioRepository.findByLogin(login);
        boolean usuarioAdmin = usuario.admin();
        if (!usuarioAdmin)
            usuarioRepository.deleteById(login);
    }
}
