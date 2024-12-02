package com.api.nodemcu.repository.amplificador2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.amplificador2.MainModelAmplificador2;

import java.util.List;
import java.util.Optional;

public interface MainRepostoryAmplificador2 extends JpaRepository<MainModelAmplificador2, Integer> {

    List<MainModelAmplificador2> findAll();

    Optional<MainModelAmplificador2> findById(Integer id);

    <MainMod extends MainModelAmplificador2> MainMod save(MainMod nodemcu);

}
