package com.api.nodemcu.repository.amplificador;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador.GeralRealizadoHorariaModelAmplificador;


public interface GeralRealizadoHorariaRepositoryAmplificador extends JpaRepository<GeralRealizadoHorariaModelAmplificador, Integer>{

    List<GeralRealizadoHorariaModelAmplificador> findAll();

    <GeralRealizado extends GeralRealizadoHorariaModelAmplificador> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_realizadohoraria_amplificador  WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaModelAmplificador> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
