package com.api.nodemcu.repository.gerenciaveis;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.GeralNodemcuModelControle;
import com.api.nodemcu.model.gerenciaveis.GeralNodemcuModelGerenciaveis;


public interface GeralNodemcuRepositoryGerenciaveis  extends JpaRepository<GeralNodemcuModelGerenciaveis, Integer>{

    List<GeralNodemcuModelGerenciaveis> findAll();

    <GeralRealizado extends GeralNodemcuModelGerenciaveis> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_thdados_gerenciaveis WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralNodemcuModelGerenciaveis> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
