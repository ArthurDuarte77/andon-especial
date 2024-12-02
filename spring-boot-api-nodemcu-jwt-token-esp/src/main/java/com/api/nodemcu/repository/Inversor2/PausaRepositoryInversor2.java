package com.api.nodemcu.repository.Inversor2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.Inversor2.PausaModelInversor2;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.model.inversor1.PausaModelInversor1;

import java.util.List;

public interface PausaRepositoryInversor2 extends JpaRepository<PausaModelInversor2, Integer> {

    List<PausaModelInversor2> findAll();


    <PausaMod extends PausaModelInversor2> PausaMod save(PausaMod pausa);

}
