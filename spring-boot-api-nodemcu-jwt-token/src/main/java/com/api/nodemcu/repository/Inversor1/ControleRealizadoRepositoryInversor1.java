package com.api.nodemcu.repository.Inversor1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.inversor1.ControleRealizadoModelInversor1;

import java.util.List;
import java.util.Optional;

public interface ControleRealizadoRepositoryInversor1 extends JpaRepository<ControleRealizadoModelInversor1, Integer> {
    List<ControleRealizadoModelInversor1> findAll();

    Optional<ControleRealizadoModelInversor1> findById(Integer id);

    <ControleRealizadoMod extends ControleRealizadoModelInversor1> ControleRealizadoMod save(ControleRealizadoMod nodemcu);
}