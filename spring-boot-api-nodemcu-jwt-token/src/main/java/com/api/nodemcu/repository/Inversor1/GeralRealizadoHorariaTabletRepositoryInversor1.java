package com.api.nodemcu.repository.Inversor1;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaModelInversor1;
import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaTabletModelInversor1;

public interface GeralRealizadoHorariaTabletRepositoryInversor1 extends JpaRepository<GeralRealizadoHorariaTabletModelInversor1, Integer>{

    List<GeralRealizadoHorariaTabletModelInversor1> findAll();

    <GeralRealizado extends GeralRealizadoHorariaTabletModelInversor1> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_realizadohoraria_tablet_inversor1 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaTabletModelInversor1> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
