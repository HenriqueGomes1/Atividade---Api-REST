package com.trabalho.retroapi.controller;

import com.trabalho.retroapi.dto.ConsoleDTO;
import com.trabalho.retroapi.service.ConsoleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consoles")
public class ConsoleController {

    private final ConsoleService service;

    public ConsoleController(ConsoleService service) {
        this.service = service;
    }

    @GetMapping
    public List<ConsoleDTO> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleDTO criar(@RequestBody ConsoleDTO dto) {
        return service.salvar(dto);
    }
}