package com.example.projetocopa.Controllers;

import com.example.projetocopa.Services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/grupo")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(){
        return "grupo/index";
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    public String gerarGrupos(){
        grupoService.gerarGrupos();
        return "grupo/index";
    }
}
