package com.api.nodemcu.repository.amplificador;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.amplificador.PausaModelAmplificador;

import java.util.List;

public interface PausaRepositoryAmplificador extends JpaRepository<PausaModelAmplificador, Integer> {

    List<PausaModelAmplificador> findAll();


    <PausaMod extends PausaModelAmplificador> PausaMod save(PausaMod pausa);

}
