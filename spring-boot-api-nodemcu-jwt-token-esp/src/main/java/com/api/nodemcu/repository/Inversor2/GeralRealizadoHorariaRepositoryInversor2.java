package com.api.nodemcu.repository.Inversor2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.Inversor2.GeralRealizadoHorariaModelInversor2;
import com.api.nodemcu.model.inversor1.GeralNodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaModelInversor1;

public interface GeralRealizadoHorariaRepositoryInversor2 extends JpaRepository<GeralRealizadoHorariaModelInversor2, Integer>{

    List<GeralRealizadoHorariaModelInversor2> findAll();

    <GeralRealizado extends GeralRealizadoHorariaModelInversor2> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_realizadohoraria_inversor2  WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaModelInversor2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
