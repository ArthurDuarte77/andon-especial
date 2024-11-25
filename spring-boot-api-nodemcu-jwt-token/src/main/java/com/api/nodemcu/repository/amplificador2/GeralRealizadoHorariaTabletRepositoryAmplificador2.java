package com.api.nodemcu.repository.amplificador2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador2.GeralRealizadoHorariaTabletModelAmplificador2;


public interface GeralRealizadoHorariaTabletRepositoryAmplificador2 extends JpaRepository<GeralRealizadoHorariaTabletModelAmplificador2, Integer>{

    List<GeralRealizadoHorariaTabletModelAmplificador2> findAll();

    <GeralRealizado extends GeralRealizadoHorariaTabletModelAmplificador2> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_realizadohoraria_tablet_amplificador2 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaTabletModelAmplificador2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
