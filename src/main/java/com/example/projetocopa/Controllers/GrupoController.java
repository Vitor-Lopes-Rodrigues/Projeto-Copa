package com.example.projetocopa.Controllers;

import com.example.projetocopa.Services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/grupo")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("geupos", grupoService.buscarGrupos());
        return "grupo/index";
    }

    @RequestMapping(value="/gerar", method= RequestMethod.GET)
    public String gerarGrupos(Model model){
        grupoService.gerarGrupos();
        model.addAttribute("geupos", grupoService.buscarGrupos());
        return "grupo/index";
    }
}
