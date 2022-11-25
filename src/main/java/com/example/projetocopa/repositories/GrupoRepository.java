package com.example.projetocopa.repositories;

import com.example.projetocopa.Models.Grupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoRepository extends CrudRepository<Grupo, Long> {

    //List<Grupo> findAll();
}
