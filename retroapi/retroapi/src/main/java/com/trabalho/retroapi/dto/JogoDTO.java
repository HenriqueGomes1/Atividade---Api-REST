package com.trabalho.retroapi.dto;

public class JogoDTO {
    private Long id;
    private String titulo;
    private String genero;
    private Long consoleId;
    private String consoleNome;

    public JogoDTO() {}

    public JogoDTO(Long id, String titulo, String genero, Long consoleId, String consoleNome) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.consoleId = consoleId;
        this.consoleNome = consoleNome;
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

    public Long getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(Long consoleId) {
        this.consoleId = consoleId;
    }

    public String getConsoleNome() {
        return consoleNome;
    }

    public void setConsoleNome(String consoleNome) {
        this.consoleNome = consoleNome;
    }
}