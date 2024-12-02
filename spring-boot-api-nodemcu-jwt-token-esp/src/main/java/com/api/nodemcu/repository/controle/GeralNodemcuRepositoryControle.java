package com.api.nodemcu.repository.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.GeralNodemcuModelControle;


public interface GeralNodemcuRepositoryControle  extends JpaRepository<GeralNodemcuModelControle, Integer>{

    List<GeralNodemcuModelControle> findAll();

    <GeralRealizado extends GeralNodemcuModelControle> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_thdados_controle WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralNodemcuModelControle> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
