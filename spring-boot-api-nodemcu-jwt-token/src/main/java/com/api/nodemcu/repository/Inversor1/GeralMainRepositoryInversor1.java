package com.api.nodemcu.repository.Inversor1;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.inversor1.GeralMainModelInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;


public interface GeralMainRepositoryInversor1 extends JpaRepository<GeralMainModelInversor1, Integer>{

    List<GeralMainModelInversor1> findAll();

    <GeralRealizado extends GeralMainModelInversor1> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_main_inversor1 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralMainModelInversor1> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
