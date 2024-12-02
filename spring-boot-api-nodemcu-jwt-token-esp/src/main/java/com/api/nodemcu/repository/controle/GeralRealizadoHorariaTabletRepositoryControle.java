package com.api.nodemcu.repository.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.GeralRealizadoHorariaTabletModelControle;

public interface GeralRealizadoHorariaTabletRepositoryControle extends JpaRepository<GeralRealizadoHorariaTabletModelControle, Integer>{

    List<GeralRealizadoHorariaTabletModelControle> findAll();

    <GeralRealizado extends GeralRealizadoHorariaTabletModelControle> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_realizadohoraria_tablet_controle WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaTabletModelControle> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
