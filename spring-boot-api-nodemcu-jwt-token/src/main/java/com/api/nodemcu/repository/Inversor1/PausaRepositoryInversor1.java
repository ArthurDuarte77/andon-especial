package com.api.nodemcu.repository.Inversor1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.model.inversor1.PausaModelInversor1;

import java.util.List;

public interface PausaRepositoryInversor1 extends JpaRepository<PausaModelInversor1, Integer> {

    List<PausaModelInversor1> findAll();


    <PausaMod extends PausaModelInversor1> PausaMod save(PausaMod pausa);

}
