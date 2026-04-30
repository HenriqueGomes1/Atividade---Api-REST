package com.trabalho.retroapi.controller;

import com.trabalho.retroapi.dto.JogoDTO;
import com.trabalho.retroapi.service.JogoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    private final JogoService service;

    public JogoController(JogoService service) {
        this.service = service;
    }

    @GetMapping
    public List<JogoDTO> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JogoDTO criar(@RequestBody JogoDTO dto) {
        return service.salvar(dto);
    }
}