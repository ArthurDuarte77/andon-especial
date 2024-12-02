package com.api.nodemcu.repository.Inversor2;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.Inversor2.GeralMainModelInversor2;
import com.api.nodemcu.model.inversor1.GeralMainModelInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;


public interface GeralMainRepositoryInversor2 extends JpaRepository<GeralMainModelInversor2, Integer>{

    List<GeralMainModelInversor2> findAll();

    <GeralRealizado extends GeralMainModelInversor2> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_main_inversor2 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralMainModelInversor2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
