package com.api.nodemcu.repository.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.GeralRealizadoHorariaModelControle;

public interface GeralRealizadoHorariaRepositoryControle extends JpaRepository<GeralRealizadoHorariaModelControle, Integer>{

    List<GeralRealizadoHorariaModelControle> findAll();

    <GeralRealizado extends GeralRealizadoHorariaModelControle> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_realizadohoraria_controle  WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaModelControle> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
