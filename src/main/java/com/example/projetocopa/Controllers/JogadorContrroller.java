package com.example.projetocopa.Controllers;

import com.example.projetocopa.Models.Jogador;
import com.example.projetocopa.Models.Posicao;
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

    @RequestMapping(value="/adicionar/{timeId}", method= RequestMethod.GET)
    public String adicionar(@PathVariable Long timeId, Model model){
        Jogador jogador = new Jogador();
        model.addAttribute("jogador", jogador);
        model.addAttribute("posicoes", Posicao.values());

        return "jogador/adicionar";
    }

    @RequestMapping(value="/adicionar/{timeId}", method= RequestMethod.POST)
    public String adicionar(@PathVariable Long timeId, Jogador jogador, Model model){
        try {
            jogadorService.adicionar(jogador, timeId);
            model.addAttribute("success", "Sucess!");
            model.addAttribute("timeId", timeId);
            return "redirect:/time/"+timeId;
        } catch(Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("jogador", jogador);
            e.printStackTrace();
            return "redirect:/jogador/adicionar/"+timeId;
        }
    }

}
