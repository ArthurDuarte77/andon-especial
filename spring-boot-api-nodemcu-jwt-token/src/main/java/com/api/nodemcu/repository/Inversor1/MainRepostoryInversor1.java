package com.api.nodemcu.repository.Inversor1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.inversor1.MainModelInversor1;

import java.util.List;
import java.util.Optional;

public interface MainRepostoryInversor1 extends JpaRepository<MainModelInversor1, Integer> {

    List<MainModelInversor1> findAll();

    Optional<MainModelInversor1> findById(Integer id);

    <MainMod extends MainModelInversor1> MainMod save(MainMod nodemcu);

}
