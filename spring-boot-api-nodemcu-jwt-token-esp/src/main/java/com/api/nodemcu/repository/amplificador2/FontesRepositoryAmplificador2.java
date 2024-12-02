package com.api.nodemcu.repository.amplificador2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.amplificador2.FontesModelAmplificador2;

import java.util.List;

public interface FontesRepositoryAmplificador2 extends JpaRepository<FontesModelAmplificador2, Integer> {

    List<FontesModelAmplificador2> findAll();

    FontesModelAmplificador2 findBymodelo(String modelo);

    <FontesMod extends FontesModelAmplificador2> FontesMod save(FontesMod fonte);

}
