package com.api.nodemcu.repository.gerenciaveis;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.controle.MainModelControle;
import com.api.nodemcu.model.gerenciaveis.MainModelGerenciaveis;

import java.util.List;
import java.util.Optional;

public interface MainRepostoryGerenciaveis extends JpaRepository<MainModelGerenciaveis, Integer> {

    List<MainModelGerenciaveis> findAll();

    Optional<MainModelGerenciaveis> findById(Integer id);

    <MainMod extends MainModelGerenciaveis> MainMod save(MainMod nodemcu);

}
