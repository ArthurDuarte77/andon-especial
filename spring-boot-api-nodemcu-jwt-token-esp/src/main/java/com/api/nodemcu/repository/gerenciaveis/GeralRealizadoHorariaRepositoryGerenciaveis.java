package com.api.nodemcu.repository.gerenciaveis;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.GeralRealizadoHorariaModelControle;
import com.api.nodemcu.model.gerenciaveis.GeralRealizadoHorariaModelGerenciaveis;

public interface GeralRealizadoHorariaRepositoryGerenciaveis extends JpaRepository<GeralRealizadoHorariaModelGerenciaveis, Integer>{

    List<GeralRealizadoHorariaModelGerenciaveis> findAll();

    <GeralRealizado extends GeralRealizadoHorariaModelGerenciaveis> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_realizadohoraria_gerenciaveis  WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaModelGerenciaveis> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
