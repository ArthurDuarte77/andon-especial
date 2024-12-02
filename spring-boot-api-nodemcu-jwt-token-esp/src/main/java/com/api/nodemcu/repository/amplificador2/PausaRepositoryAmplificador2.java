package com.api.nodemcu.repository.amplificador2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.amplificador2.PausaModelAmplificador2;

import java.util.List;

public interface PausaRepositoryAmplificador2 extends JpaRepository<PausaModelAmplificador2, Integer> {

    List<PausaModelAmplificador2> findAll();


    <PausaMod extends PausaModelAmplificador2> PausaMod save(PausaMod pausa);

}
