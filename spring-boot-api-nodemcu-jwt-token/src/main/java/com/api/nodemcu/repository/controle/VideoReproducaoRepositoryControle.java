package com.api.nodemcu.repository.controle;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.OperationModelControle;
import com.api.nodemcu.model.controle.VideoReproducaoModelControle;


public interface VideoReproducaoRepositoryControle extends JpaRepository<VideoReproducaoModelControle, Integer> {

    List<VideoReproducaoModelControle> findAll();

    <PausaMod extends VideoReproducaoModelControle> PausaMod save(PausaMod pausa);

    List<VideoReproducaoModelControle> findByNameId(OperationModelControle name);

}
