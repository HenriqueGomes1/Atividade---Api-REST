package com.trabalho.retroapi.repository;

import com.trabalho.retroapi.entity.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {
}