package com.example.projetocopa.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="time")
public class Time implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable=false)
    private Grupo grupo;
    @OneToMany
    @JoinColumn(name = "time_id")
    private List<Jogador> jogadores;
}
