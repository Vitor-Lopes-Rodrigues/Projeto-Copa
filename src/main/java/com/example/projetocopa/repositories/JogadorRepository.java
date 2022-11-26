package com.example.projetocopa.repositories;

import com.example.projetocopa.Models.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Long> {
    Jogador findFirstById(Long id);
}
