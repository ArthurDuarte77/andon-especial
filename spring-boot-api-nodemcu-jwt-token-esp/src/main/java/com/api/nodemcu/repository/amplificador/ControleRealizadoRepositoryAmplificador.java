package com.api.nodemcu.repository.amplificador;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.amplificador.ControleRealizadoModelAmplificador;

import java.util.List;
import java.util.Optional;

public interface ControleRealizadoRepositoryAmplificador extends JpaRepository<ControleRealizadoModelAmplificador, Integer> {
    List<ControleRealizadoModelAmplificador> findAll();

    Optional<ControleRealizadoModelAmplificador> findById(Integer id);

    <ControleRealizadoMod extends ControleRealizadoModelAmplificador> ControleRealizadoMod save(ControleRealizadoMod nodemcu);
}