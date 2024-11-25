package com.api.nodemcu.repository.controle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.controle.ControleRealizadoModelControle;

import java.util.List;
import java.util.Optional;

public interface ControleRealizadoRepositoryControle extends JpaRepository<ControleRealizadoModelControle, Integer> {
    List<ControleRealizadoModelControle> findAll();

    Optional<ControleRealizadoModelControle> findById(Integer id);

    <ControleRealizadoMod extends ControleRealizadoModelControle> ControleRealizadoMod save(ControleRealizadoMod nodemcu);
}