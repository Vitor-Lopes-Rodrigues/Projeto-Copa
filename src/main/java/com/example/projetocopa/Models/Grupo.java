package com.example.projetocopa.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany
    @JoinColumn(name = "grupo_id")
    private List<Time> times;


    public Grupo(String nome) {
        this.nome = nome;
    }

    public Grupo() {}

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

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }
}
