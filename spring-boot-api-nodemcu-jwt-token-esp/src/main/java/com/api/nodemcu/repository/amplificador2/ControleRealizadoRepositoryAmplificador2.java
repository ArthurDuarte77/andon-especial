package com.api.nodemcu.repository.amplificador2;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.amplificador2.ControleRealizadoModelAmplificador2;

import java.util.List;
import java.util.Optional;

public interface ControleRealizadoRepositoryAmplificador2 extends JpaRepository<ControleRealizadoModelAmplificador2, Integer> {
    List<ControleRealizadoModelAmplificador2> findAll();

    Optional<ControleRealizadoModelAmplificador2> findById(Integer id);

    <ControleRealizadoMod extends ControleRealizadoModelAmplificador2> ControleRealizadoMod save(ControleRealizadoMod nodemcu);
}