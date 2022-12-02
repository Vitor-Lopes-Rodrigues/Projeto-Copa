package com.example.projetocopa.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="time")
public class Time {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String imagem;
    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable=false)
    private Grupo grupo;
    @OneToMany
    @JoinColumn(name = "time_id")
    private List<Jogador> jogadores;


    public Time(String nome, Grupo grupo, String imagem) {
        this.nome = nome;
        this.grupo = grupo;
        this.imagem = imagem;
    }

    public Time() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
