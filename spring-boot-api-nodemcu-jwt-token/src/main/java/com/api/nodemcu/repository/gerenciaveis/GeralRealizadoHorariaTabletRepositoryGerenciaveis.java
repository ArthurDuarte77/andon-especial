package com.api.nodemcu.repository.gerenciaveis;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.GeralRealizadoHorariaTabletModelControle;
import com.api.nodemcu.model.gerenciaveis.GeralRealizadoHorariaTabletModelGerenciaveis;

public interface GeralRealizadoHorariaTabletRepositoryGerenciaveis extends JpaRepository<GeralRealizadoHorariaTabletModelGerenciaveis, Integer>{

    List<GeralRealizadoHorariaTabletModelGerenciaveis> findAll();

    <GeralRealizado extends GeralRealizadoHorariaTabletModelGerenciaveis> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_realizadohoraria_tablet_gerenciaveis WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaTabletModelGerenciaveis> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
