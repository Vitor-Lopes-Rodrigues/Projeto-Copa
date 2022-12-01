package com.example.projetocopa.Controllers;

import com.example.projetocopa.Models.Time;
import com.example.projetocopa.Models.Usuario;
import com.example.projetocopa.Services.GrupoService;
import com.example.projetocopa.Services.JogadorService;
import com.example.projetocopa.Services.TimeService;
import com.example.projetocopa.Services.UsuarioService;
import com.example.projetocopa.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    GrupoService grupoService;

    @RequestMapping(value="/time/{id}", method= RequestMethod.GET)
    public String index(Model model, @PathVariable Long id){
        model.addAttribute("time", timeService.buscarPorId(id));
        return "time/index";
    }


    @RequestMapping(value="/adicionar/{grupoId}", method= RequestMethod.GET)
    public String adicionar(@PathVariable Long grupoId,Model model){
        Time time = new Time();
        time.setGrupo(grupoService.buscarGrupoPorId(grupoId));
        model.addAttribute("time", time);
        return "time/adicionar";
    }

    @RequestMapping(value="/adicionar/{grupoId}", method= RequestMethod.POST)
    public String adicionar(@ModelAttribute Time time,
                            @PathVariable Long grupoId,
                            @RequestParam("fotoTime") MultipartFile fotoTime,
                            Model model
    ){
        try {
            //salvando imagem (o método retorna o nome da imagem)
            time.setImagem(timeService.salvarImagem(fotoTime));
            //inserindo dados no banco
            timeService.adicionar(time, grupoId);
            model.addAttribute("success", "Sucess!");
            return "redirect:/grupo/";
        } catch(Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("time", time);
            e.printStackTrace();
            return "time/adicionar/"+grupoId;
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
