package com.example.projetocopa.Models;

import javax.persistence.*;

@Entity
@Table(name="jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;
    private int idade;
    private Posicao posicao;
    @ManyToOne
    @JoinColumn(name = "time_id", nullable=false)
    private Time time;
}
