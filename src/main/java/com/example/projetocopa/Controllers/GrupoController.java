package com.example.projetocopa.Controllers;

import com.example.projetocopa.Services.GrupoService;
import com.example.projetocopa.Services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/grupo")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @Autowired
    TimeService timeService;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("grupos", grupoService.buscarGrupos());
        return "grupo/index";
    }

    @RequestMapping(value="/gerar", method= RequestMethod.GET)
    public String gerarGrupos(Model model){
        grupoService.gerarGrupos();
        model.addAttribute("grupos", grupoService.buscarGrupos());
        return "grupo/index";
    }

    @RequestMapping(value="/zerar", method= RequestMethod.GET)
    public String apagarGrupos(Model model){
        grupoService.zerarGrupos();
        model.addAttribute("grupos", grupoService.buscarGrupos());
        return "grupo/index";
    }


    @RequestMapping(value="/removerTime/{id}", method= RequestMethod.GET)
    public String remover(@PathVariable Long id, Model model){
        timeService.deletar(id);
        model.addAttribute("success", "Success!");
        model.addAttribute("grupos", grupoService.buscarGrupos());
        return "grupo/index";
    }
}
