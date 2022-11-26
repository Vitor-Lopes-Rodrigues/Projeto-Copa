package com.example.projetocopa.repositories;

import com.example.projetocopa.Models.Time;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends CrudRepository<Time, Long> {

}
