package com.api.nodemcu.repository.amplificador2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador2.GeralRealizadoHorariaModelAmplificador2;


public interface GeralRealizadoHorariaRepositoryAmplificador2 extends JpaRepository<GeralRealizadoHorariaModelAmplificador2, Integer>{

    List<GeralRealizadoHorariaModelAmplificador2> findAll();

    <GeralRealizado extends GeralRealizadoHorariaModelAmplificador2> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_realizadohoraria_amplificador2  WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaModelAmplificador2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
