package com.api.nodemcu.repository.Inversor2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.Inversor2.ControleRealizadoModelInversor2;

import java.util.List;
import java.util.Optional;

public interface ControleRealizadoRepositoryInversor2 extends JpaRepository<ControleRealizadoModelInversor2, Integer> {
    List<ControleRealizadoModelInversor2> findAll();

    Optional<ControleRealizadoModelInversor2> findById(Integer id);

    <ControleRealizadoMod extends ControleRealizadoModelInversor2> ControleRealizadoMod save(ControleRealizadoMod nodemcu);
}