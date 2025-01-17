package com.api.nodemcu.repository.gerenciaveis;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.gerenciaveis.ContadorGerenciaveis;




public interface ContadorRepositoryGerenciaveis extends JpaRepository<ContadorGerenciaveis, Long> {
}

