package com.api.nodemcu.repository.amplificador;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.amplificador.FontesModelAmplificador;

import java.util.List;

public interface FontesRepositoryAmplificador extends JpaRepository<FontesModelAmplificador, Integer> {

    List<FontesModelAmplificador> findAll();

    FontesModelAmplificador findBymodelo(String modelo);

    <FontesMod extends FontesModelAmplificador> FontesMod save(FontesMod fonte);

}
