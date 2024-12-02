package com.api.nodemcu.repository.Inversor2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.Inversor2.GeralRealizadoHorariaTabletModelInversor2;
import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaModelInversor1;
import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaTabletModelInversor1;

public interface GeralRealizadoHorariaTabletRepositoryInversor2 extends JpaRepository<GeralRealizadoHorariaTabletModelInversor2, Integer>{

    List<GeralRealizadoHorariaTabletModelInversor2> findAll();

    <GeralRealizado extends GeralRealizadoHorariaTabletModelInversor2> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_realizadohoraria_tablet_inversor2 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralRealizadoHorariaTabletModelInversor2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
