package com.api.nodemcu.repository.amplificador;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador.GeralMainModelAmplificador;




public interface GeralMainRepositoryAmplificador extends JpaRepository<GeralMainModelAmplificador, Integer>{

    List<GeralMainModelAmplificador> findAll();

    <GeralRealizado extends GeralMainModelAmplificador> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_main_amplificador WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralMainModelAmplificador> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
