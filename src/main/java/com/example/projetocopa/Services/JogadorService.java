package com.example.projetocopa.Services;

import com.example.projetocopa.Models.Grupo;
import com.example.projetocopa.Models.Jogador;
import com.example.projetocopa.Models.Time;
import com.example.projetocopa.repositories.GrupoRepository;
import com.example.projetocopa.repositories.JogadorRepository;
import com.example.projetocopa.repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;

    @Autowired
    TimeRepository timeRepository;

    public Jogador buscarJogador(Long id){
        return jogadorRepository.findFirstById(id);
    }

    public List<Jogador> buscarJogadoresPorTime(Long timeId){
        return timeRepository.findFirstById(timeId).getJogadores();
    }

    public void adicionar(Jogador jogador, Long timeId){
        Time time = timeRepository.findFirstById(timeId);
        if (time.getJogadores().size() <11) {
            jogador.setTime(time);
            jogadorRepository.save(jogador);
        }
    }

    public void deletar(Long id){
        jogadorRepository.deleteById(id);
    }
    public void deletar(Jogador jogador){
        jogadorRepository.delete(jogador);
    }
}
