package com.api.nodemcu.repository.gerenciaveis;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.controle.FontesModelControle;
import com.api.nodemcu.model.gerenciaveis.FontesModelGerenciaveis;

import java.util.List;

public interface FontesRepositoryGerenciaveis extends JpaRepository<FontesModelGerenciaveis, Integer> {

    List<FontesModelGerenciaveis> findAll();

    FontesModelGerenciaveis findBymodelo(String modelo);

    <FontesMod extends FontesModelGerenciaveis> FontesMod save(FontesMod fonte);

}
