package com.example.projetocopa.Services;

import com.example.projetocopa.Models.Grupo;
import com.example.projetocopa.Models.Time;
import com.example.projetocopa.repositories.GrupoRepository;
import com.example.projetocopa.repositories.TimeRepository;
import com.example.projetocopa.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    TimeRepository timeRepository;
    @Autowired
    GrupoRepository grupoRepository;

    public List<Time> buscarTimes(){
        return (List<Time>) timeRepository.findAll();
    }

    public void adicionar(Time time, Long grupoId){
        Grupo grupo = grupoRepository.findFirstById(grupoId);
        if (grupo.getTimes().size() <4)
            timeRepository.save(time);
    }

    public void deletar(Long id){
        timeRepository.deleteById(id);
    }
}