package com.api.nodemcu.repository.Inversor2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.Inversor2.OperationModelInversor2;
import com.api.nodemcu.model.Inversor2.VideoReproducaoModelInversor2;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.model.inversor1.VideoReproducaoModelInversor1;

public interface VideoReproducaoRepositoryInversor2 extends JpaRepository<VideoReproducaoModelInversor2, Integer> {

    List<VideoReproducaoModelInversor2> findAll();

    <PausaMod extends VideoReproducaoModelInversor2> PausaMod save(PausaMod pausa);

    List<VideoReproducaoModelInversor2> findByNameId(OperationModelInversor2 name);

}
