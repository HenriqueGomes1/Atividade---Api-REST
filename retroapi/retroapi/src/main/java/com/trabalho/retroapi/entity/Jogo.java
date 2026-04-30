package com.trabalho.retroapi.entity;

import jakarta.persistence.*;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;

    @ManyToOne
    @JoinColumn(name = "console_id")
    private Console console;

    public Jogo() {}

    public Jogo(Long id, String titulo, String genero, Console console) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.console = console;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }
}