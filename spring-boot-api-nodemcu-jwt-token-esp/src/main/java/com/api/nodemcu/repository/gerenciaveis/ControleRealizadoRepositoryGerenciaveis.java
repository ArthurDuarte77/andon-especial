package com.api.nodemcu.repository.gerenciaveis;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.gerenciaveis.ControleRealizadoModelGerenciaveis;

import java.util.List;
import java.util.Optional;

public interface ControleRealizadoRepositoryGerenciaveis extends JpaRepository<ControleRealizadoModelGerenciaveis, Integer> {
    List<ControleRealizadoModelGerenciaveis> findAll();

    Optional<ControleRealizadoModelGerenciaveis> findById(Integer id);

    <ControleRealizadoMod extends ControleRealizadoModelGerenciaveis> ControleRealizadoMod save(ControleRealizadoMod nodemcu);
}