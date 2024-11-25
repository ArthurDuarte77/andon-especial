package com.api.nodemcu.repository.amplificador2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador2.OperationModelAmplificador2;
import com.api.nodemcu.model.amplificador2.VideoReproducaoModelAmplificador2;




public interface VideoReproducaoRepositoryAmplificador2 extends JpaRepository<VideoReproducaoModelAmplificador2, Integer> {

    List<VideoReproducaoModelAmplificador2> findAll();

    <PausaMod extends VideoReproducaoModelAmplificador2> PausaMod save(PausaMod pausa);

    List<VideoReproducaoModelAmplificador2> findByNameId(OperationModelAmplificador2 name);

}
