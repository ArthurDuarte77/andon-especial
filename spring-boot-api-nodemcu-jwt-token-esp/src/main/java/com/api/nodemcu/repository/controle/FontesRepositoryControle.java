package com.api.nodemcu.repository.controle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.controle.FontesModelControle;

import java.util.List;

public interface FontesRepositoryControle extends JpaRepository<FontesModelControle, Integer> {

    List<FontesModelControle> findAll();

    FontesModelControle findBymodelo(String modelo);

    <FontesMod extends FontesModelControle> FontesMod save(FontesMod fonte);

}
