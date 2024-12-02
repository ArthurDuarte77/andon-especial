package com.api.nodemcu.repository.Inversor1;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.inversor1.GeralNodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;

public interface GeralNodemcuRepositoryInversor1  extends JpaRepository<GeralNodemcuModelInversor1, Integer>{

    List<GeralNodemcuModelInversor1> findAll();

    <GeralRealizado extends GeralNodemcuModelInversor1> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_thdados_inversor1 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralNodemcuModelInversor1> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
