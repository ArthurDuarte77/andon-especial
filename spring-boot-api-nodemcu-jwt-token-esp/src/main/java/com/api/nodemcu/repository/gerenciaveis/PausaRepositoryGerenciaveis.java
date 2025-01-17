package com.api.nodemcu.repository.gerenciaveis;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.controle.PausaModelControle;
import com.api.nodemcu.model.gerenciaveis.PausaModelGerenciaveis;

import java.util.List;

public interface PausaRepositoryGerenciaveis extends JpaRepository<PausaModelGerenciaveis, Integer> {

    List<PausaModelGerenciaveis> findAll();


    <PausaMod extends PausaModelGerenciaveis> PausaMod save(PausaMod pausa);

}
