package com.api.nodemcu.repository.controle;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.GeralMainModelControle;



public interface GeralMainRepositoryControle extends JpaRepository<GeralMainModelControle, Integer>{

    List<GeralMainModelControle> findAll();

    <GeralRealizado extends GeralMainModelControle> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_main_controle WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralMainModelControle> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
