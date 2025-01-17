package com.api.nodemcu.repository.gerenciaveis;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.OperationModelControle;
import com.api.nodemcu.model.controle.VideoReproducaoModelControle;
import com.api.nodemcu.model.gerenciaveis.OperationModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.VideoReproducaoModelGerenciaveis;


public interface VideoReproducaoRepositoryGerenciaveis extends JpaRepository<VideoReproducaoModelGerenciaveis, Integer> {

    List<VideoReproducaoModelGerenciaveis> findAll();

    <PausaMod extends VideoReproducaoModelGerenciaveis> PausaMod save(PausaMod pausa);

    List<VideoReproducaoModelGerenciaveis> findByNameId(OperationModelGerenciaveis name);

}
