package com.api.nodemcu.repository.controle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.controle.ContadorControle;



public interface ContadorRepositoryControle extends JpaRepository<ContadorControle, Long> {
}

