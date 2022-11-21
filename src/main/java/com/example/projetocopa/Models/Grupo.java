package com.example.projetocopa.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToMany
    @JoinColumn(name = "grupo_id")
    private List<Time> times;


}
