package com.api.nodemcu.repository.Inversor2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.Inversor2.MainModelInversor2;
import com.api.nodemcu.model.inversor1.MainModelInversor1;

import java.util.List;
import java.util.Optional;

public interface MainRepostoryInversor2 extends JpaRepository<MainModelInversor2, Integer> {

    List<MainModelInversor2> findAll();

    Optional<MainModelInversor2> findById(Integer id);

    <MainMod extends MainModelInversor2> MainMod save(MainMod nodemcu);

}
