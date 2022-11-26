package com.example.projetocopa.Controllers;

import com.example.projetocopa.Models.Jogador;
import com.example.projetocopa.Models.Time;
import com.example.projetocopa.Services.JogadorService;
import com.example.projetocopa.Services.TimeService;
import com.example.projetocopa.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/jogador")
public class JogadorContrroller {
    @Autowired
    JogadorService jogadorService;

    @Autowired
    TimeRepository timeRepository;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index(Model model){
        Long timeId = Long.parseLong((String) Objects.requireNonNull(model.getAttribute("timeId")));
        model.addAttribute("jogadores", jogadorService.buscarJogadoresPorTime(timeId));
        return "time/index";
    }


    @RequestMapping(value="/adicionar", method= RequestMethod.GET)
    public String adicionar(Model model){
        Long timeId = Long.parseLong((String) Objects.requireNonNull(model.getAttribute("timeId")));
        Jogador jogador = new Jogador();
        jogador.setTime(timeRepository.findFirstById(timeId));
        model.addAttribute("jogador", jogador);
        return "time/adicionar";
    }

    @RequestMapping(value="/adicionar", method= RequestMethod.POST)
    public String adicionar(Jogador jogador, Model model){
        try {
            jogadorService.adicionar(jogador, jogador.getTime().getId());
            model.addAttribute("success", "Sucess!");
            model.addAttribute("timeId", jogador.getTime().getId());
            return "time/index";
        } catch(Exception e) {
            Pattern compile = Pattern.compile("message\":\"(.*)\",");
            Matcher m = compile.matcher(e.getMessage());
            m.find();
            model.addAttribute("error", m.group(1));
            model.addAttribute("jogador", jogador);
            return "time/adicionar";
        } finally {
            model.addAttribute("jogadores", jogadorService.buscarJogadoresPorTime(jogador.getTime().getId()));
        }
    }

    @RequestMapping(value="/remover/{id}", method= RequestMethod.GET)
    public String remover(@PathVariable Long id, Model model){
        jogadorService.deletar(id);
        model.addAttribute("success", "Success!");
        Long timeId = Long.parseLong((String) Objects.requireNonNull(model.getAttribute("timeId")));
        model.addAttribute("jogadores", jogadorService.buscarJogadoresPorTime(timeId));
        return "time/index";
    }
}
