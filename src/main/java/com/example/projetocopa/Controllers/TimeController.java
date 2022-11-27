package com.example.projetocopa.Controllers;

import com.example.projetocopa.Models.Time;
import com.example.projetocopa.Models.Usuario;
import com.example.projetocopa.Services.JogadorService;
import com.example.projetocopa.Services.TimeService;
import com.example.projetocopa.Services.UsuarioService;
import com.example.projetocopa.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/time")
public class TimeController {

    @Autowired
    TimeService timeService;

    @Autowired
    JogadorService jogadorService;

    @RequestMapping(value="/time/{id}", method= RequestMethod.GET)
    public String index(Model model, @PathVariable Long id){
        model.addAttribute("jogadores", timeService.buscarPorId(id).getJogadores());
        return "time/index";
    }


    @RequestMapping(value="/adicionar", method= RequestMethod.GET)
    public String adicionar(Model model){
        model.addAttribute("time", new Time());
        return "time/adicionar";
    }

    @RequestMapping(value="/adicionar", method= RequestMethod.POST)
    public String adicionar(Time time, Model model){
        try {
            Long grupoId = Long.parseLong((String) Objects.requireNonNull(model.getAttribute("grupoId")));
            timeService.adicionar(time, grupoId);
            model.addAttribute("success", "Sucess!");
            return "time/index";
        } catch(Exception e) {
            Pattern compile = Pattern.compile("message\":\"(.*)\",");
            Matcher m = compile.matcher(e.getMessage());
            m.find();
            model.addAttribute("error", m.group(1));
            model.addAttribute("time", time);
            return "time/adicionar";
        } finally {
            model.addAttribute("times", timeService.buscarTimes());
        }
    }

    @RequestMapping(value="/removerJogador/{id}", method= RequestMethod.GET)
    public String remover(@PathVariable Long id, Model model, Long timeId){
        jogadorService.deletar(id);
        model.addAttribute("success", "Success!");
        model.addAttribute("jogadores", timeService.buscarPorId(timeId).getJogadores());
        return "time/index";
    }

}
