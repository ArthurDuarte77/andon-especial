package com.api.nodemcu.repository.amplificador;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.amplificador.MainModelAmplificador;

import java.util.List;
import java.util.Optional;

public interface MainRepostoryAmplificador extends JpaRepository<MainModelAmplificador, Integer> {

    List<MainModelAmplificador> findAll();

    Optional<MainModelAmplificador> findById(Integer id);

    <MainMod extends MainModelAmplificador> MainMod save(MainMod nodemcu);

}
