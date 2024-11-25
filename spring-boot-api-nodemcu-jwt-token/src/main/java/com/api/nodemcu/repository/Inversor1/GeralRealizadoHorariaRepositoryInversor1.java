package com.api.nodemcu.repository.Inversor1;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.inversor1.GeralNodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaModelInversor1;

public interface GeralRealizadoHorariaRepositoryInversor1 extends JpaRepository<GeralRealizadoHorariaModelInversor1, Integer>{

    List<GeralRealizadoHorariaModelInversor1> findAll();

    <GeralRealizado extends GeralRealizadoHorariaModelInversor1> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_realizadohoraria_inversor1 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaModelInversor1> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
