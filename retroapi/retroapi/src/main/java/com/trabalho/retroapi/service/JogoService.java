package com.trabalho.retroapi.service;

import com.trabalho.retroapi.dto.JogoDTO;
import com.trabalho.retroapi.entity.Console;
import com.trabalho.retroapi.entity.Jogo;
import com.trabalho.retroapi.repository.ConsoleRepository;
import com.trabalho.retroapi.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;
    private final ConsoleRepository consoleRepository;

    public JogoService(JogoRepository jogoRepository, ConsoleRepository consoleRepository) {
        this.jogoRepository = jogoRepository;
        this.consoleRepository = consoleRepository;
    }

    public List<JogoDTO> listarTodos() {
        List<Jogo> jogos = jogoRepository.findAll();
        List<JogoDTO> dtos = new ArrayList<>();
        
        for (Jogo j : jogos) {
            String consoleNome = j.getConsole() != null ? j.getConsole().getNome() : null;
            Long consoleId = j.getConsole() != null ? j.getConsole().getId() : null;
            dtos.add(new JogoDTO(j.getId(), j.getTitulo(), j.getGenero(), consoleId, consoleNome));
        }
        return dtos;
    }

    public JogoDTO salvar(JogoDTO dto) {
        Jogo jogo = new Jogo();
        jogo.setTitulo(dto.getTitulo());
        jogo.setGenero(dto.getGenero());

        if (dto.getConsoleId() != null) {
            Optional<Console> consoleOpt = consoleRepository.findById(dto.getConsoleId());
            consoleOpt.ifPresent(jogo::setConsole);
        }

        jogo = jogoRepository.save(jogo);

        dto.setId(jogo.getId());
        if(jogo.getConsole() != null){
            dto.setConsoleNome(jogo.getConsole().getNome());
        }
        return dto;
    }
}