package com.example.projetocopa.Controllers;

import com.example.projetocopa.Models.Time;
import com.example.projetocopa.Models.Usuario;
import com.example.projetocopa.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @RequestMapping(value="/adicionar", method= RequestMethod.GET)
    public String adicionar(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/adicionar";
    }

    @RequestMapping(value="/adicionar", method= RequestMethod.POST)
    public String adicionar(
            @ModelAttribute Usuario usuario,
            @RequestParam("admin") boolean admin,
            Model model
    ){
        try {
            usuarioService.adicionar(usuario,admin);
            model.addAttribute("success", "Sucess!");
            return "redirect:/usuario/";
        } catch(Exception e) {
            model.addAttribute("error", e.getMessage());
            e.printStackTrace();
            model.addAttribute("usuario", new Usuario());
            return "usuario/adicionar";
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
        return "redirect:/usuario/";
    }

}
