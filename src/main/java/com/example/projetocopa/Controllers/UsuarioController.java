package com.example.projetocopa.Controllers;

import com.example.projetocopa.Models.Usuario;
import com.example.projetocopa.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("usuarios", usuarioService.buscaUsuarios());
        return "usuario/index";
    }


    @RequestMapping(value="/adicionarr", method= RequestMethod.GET)
    public String adicionar(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/adicionar";
    }

    @RequestMapping(value="/adicionarr", method= RequestMethod.POST)
    public String adicionar(Usuario usuario, Model model){
        try {
            String admin = (String) model.getAttribute("admin");
            usuarioService.adicionar(usuario,admin);
            model.addAttribute("success", "Sucess!");
            return "usuario/index";
        } catch(Exception e) {
            Pattern compile = Pattern.compile("message\":\"(.*)\",");
            Matcher m = compile.matcher(e.getMessage());
            m.find();
            model.addAttribute("error", m.group(1));
            model.addAttribute("todo", usuario);
            return "usuario/adicionar";
        } finally {
            model.addAttribute("tousuarios", usuarioService.buscaUsuarios());
        }
    }

    @RequestMapping(value="/editar", method= RequestMethod.GET)
    public String editar(){
        return "usuario/editar";
    }

    @RequestMapping(value="/remover/{login}", method= RequestMethod.GET)
    public String remover(@PathVariable String login, Model model){
       usuarioService.deletar(login);
        model.addAttribute("success", "Success!");
        model.addAttribute("usuarios", usuarioService.buscaUsuarios());
        return "usuario/index";
    }

}
