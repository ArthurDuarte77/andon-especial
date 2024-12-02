package com.api.nodemcu.repository.controle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.controle.MainModelControle;

import java.util.List;
import java.util.Optional;

public interface MainRepostoryControle extends JpaRepository<MainModelControle, Integer> {

    List<MainModelControle> findAll();

    Optional<MainModelControle> findById(Integer id);

    <MainMod extends MainModelControle> MainMod save(MainMod nodemcu);

}
