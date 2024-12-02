package com.api.nodemcu.repository.amplificador;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador.OperationModelAmplificador;
import com.api.nodemcu.model.amplificador.VideoReproducaoModelAmplificador;



public interface VideoReproducaoRepositoryAmplificador extends JpaRepository<VideoReproducaoModelAmplificador, Integer> {

    List<VideoReproducaoModelAmplificador> findAll();

    <PausaMod extends VideoReproducaoModelAmplificador> PausaMod save(PausaMod pausa);

    List<VideoReproducaoModelAmplificador> findByNameId(OperationModelAmplificador name);

}
