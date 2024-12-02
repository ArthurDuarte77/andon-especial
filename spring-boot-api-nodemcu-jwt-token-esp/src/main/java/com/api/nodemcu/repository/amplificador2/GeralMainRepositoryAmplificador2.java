package com.api.nodemcu.repository.amplificador2;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador2.GeralMainModelAmplificador2;





public interface GeralMainRepositoryAmplificador2 extends JpaRepository<GeralMainModelAmplificador2, Integer>{

    List<GeralMainModelAmplificador2> findAll();

    <GeralRealizado extends GeralMainModelAmplificador2> GeralRealizado save(GeralRealizado nodemcu);
    
    @Query(value="SELECT * FROM geral_main_amplificador2 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralMainModelAmplificador2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
