package com.trabalho.retroapi.service;

import com.trabalho.retroapi.dto.ConsoleDTO;
import com.trabalho.retroapi.entity.Console;
import com.trabalho.retroapi.repository.ConsoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsoleService {

    private final ConsoleRepository repository;

    public ConsoleService(ConsoleRepository repository) {
        this.repository = repository;
    }

    public List<ConsoleDTO> listarTodos() {
        List<Console> consoles = repository.findAll();
        List<ConsoleDTO> dtos = new ArrayList<>();
        
        for (Console c : consoles) {
            dtos.add(new ConsoleDTO(c.getId(), c.getNome(), c.getFabricante()));
        }
        return dtos;
    }

    public ConsoleDTO salvar(ConsoleDTO dto) {
        Console console = new Console();
        console.setNome(dto.getNome());
        console.setFabricante(dto.getFabricante());
        
        console = repository.save(console);
        
        dto.setId(console.getId());
        return dto;
    }
}