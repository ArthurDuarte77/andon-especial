package com.api.nodemcu.repository.Inversor2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.Inversor2.FontesModelInversor2;
import com.api.nodemcu.model.inversor1.FontesModelInversor1;

import java.util.List;

public interface FontesRepositoryInversor2 extends JpaRepository<FontesModelInversor2, Integer> {

    List<FontesModelInversor2> findAll();

    FontesModelInversor2 findBymodelo(String modelo);

    <FontesMod extends FontesModelInversor2> FontesMod save(FontesMod fonte);

}
