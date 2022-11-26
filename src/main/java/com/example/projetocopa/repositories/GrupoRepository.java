package com.example.projetocopa.repositories;

import com.example.projetocopa.Models.Grupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrupoRepository extends CrudRepository<Grupo, Long> {

    List<Grupo> findAll();
    Grupo findFirstById(Long id);
}
