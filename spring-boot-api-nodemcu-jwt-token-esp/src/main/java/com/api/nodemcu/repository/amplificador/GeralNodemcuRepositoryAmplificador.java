package com.api.nodemcu.repository.amplificador;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador.GeralNodemcuModelAmplificador;



public interface GeralNodemcuRepositoryAmplificador  extends JpaRepository<GeralNodemcuModelAmplificador, Integer>{

    List<GeralNodemcuModelAmplificador> findAll();

    <GeralRealizado extends GeralNodemcuModelAmplificador> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_thdados_amplificador WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralNodemcuModelAmplificador> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
