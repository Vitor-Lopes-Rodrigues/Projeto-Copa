package com.example.projetocopa.Services;

import com.example.projetocopa.Models.Grupo;
import com.example.projetocopa.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    GrupoRepository grupoRepository;

    public List<Grupo> buscarGrupos(){
        return (List<Grupo>) grupoRepository.findAll();
    }

    public void gerarGrupos(){
        List<Grupo> grupos = (List<Grupo>) grupoRepository.findAll();
        
        if (grupos.size() > 0){
            zerarGrupos();
        }
        
        String[] letrasGrupos = {"A","B","C","D","E","F","G","H"};
        for (String letra : letrasGrupos){
            grupoRepository.save(new Grupo("Grupo "+letra));
        }
    }
    
    public void zerarGrupos(){
        grupoRepository.deleteAll();
    }
}
