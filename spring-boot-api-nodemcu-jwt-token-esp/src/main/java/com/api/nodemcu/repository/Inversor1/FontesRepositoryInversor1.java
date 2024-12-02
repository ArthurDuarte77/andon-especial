package com.api.nodemcu.repository.Inversor1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.inversor1.FontesModelInversor1;

import java.util.List;

public interface FontesRepositoryInversor1 extends JpaRepository<FontesModelInversor1, Integer> {

    List<FontesModelInversor1> findAll();

    FontesModelInversor1 findBymodelo(String modelo);

    <FontesMod extends FontesModelInversor1> FontesMod save(FontesMod fonte);

}
