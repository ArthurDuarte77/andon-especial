package com.api.nodemcu.repository.controle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.controle.PausaModelControle;

import java.util.List;

public interface PausaRepositoryControle extends JpaRepository<PausaModelControle, Integer> {

    List<PausaModelControle> findAll();


    <PausaMod extends PausaModelControle> PausaMod save(PausaMod pausa);

}
