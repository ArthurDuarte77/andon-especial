package com.api.nodemcu.repository.gerenciaveis;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.GeralMainModelControle;
import com.api.nodemcu.model.gerenciaveis.GeralMainModelGerenciaveis;



public interface GeralMainRepositoryGerenciaveis extends JpaRepository<GeralMainModelGerenciaveis, Integer>{

    List<GeralMainModelGerenciaveis> findAll();

    <GeralRealizado extends GeralMainModelGerenciaveis> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_main_gerenciaveis WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralMainModelGerenciaveis> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
