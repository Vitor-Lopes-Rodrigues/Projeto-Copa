package com.example.projetocopa.repositories;

import com.example.projetocopa.Models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
    Role findByNomeRole(String nomeRole);
}
