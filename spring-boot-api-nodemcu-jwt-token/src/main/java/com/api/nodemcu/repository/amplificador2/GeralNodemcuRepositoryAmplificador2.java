package com.api.nodemcu.repository.amplificador2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador2.GeralNodemcuModelAmplificador2;



public interface GeralNodemcuRepositoryAmplificador2  extends JpaRepository<GeralNodemcuModelAmplificador2, Integer>{

    List<GeralNodemcuModelAmplificador2> findAll();

    <GeralRealizado extends GeralNodemcuModelAmplificador2> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_thdados_amplificador2 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralNodemcuModelAmplificador2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
