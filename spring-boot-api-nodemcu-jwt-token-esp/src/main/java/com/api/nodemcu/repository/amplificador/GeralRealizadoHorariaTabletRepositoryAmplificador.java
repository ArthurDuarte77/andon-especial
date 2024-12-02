package com.api.nodemcu.repository.amplificador;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador.GeralRealizadoHorariaTabletModelAmplificador;


public interface GeralRealizadoHorariaTabletRepositoryAmplificador extends JpaRepository<GeralRealizadoHorariaTabletModelAmplificador, Integer>{

    List<GeralRealizadoHorariaTabletModelAmplificador> findAll();

    <GeralRealizado extends GeralRealizadoHorariaTabletModelAmplificador> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_realizadohoraria_tablet_amplificador WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaTabletModelAmplificador> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
