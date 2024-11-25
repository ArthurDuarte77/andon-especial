package com.api.nodemcu.repository.Inversor2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.Inversor2.GeralNodemcuModelInversor2;
import com.api.nodemcu.model.inversor1.GeralNodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;

public interface GeralNodemcuRepositoryInversor2  extends JpaRepository<GeralNodemcuModelInversor2, Integer>{

    List<GeralNodemcuModelInversor2> findAll();

    <GeralRealizado extends GeralNodemcuModelInversor2> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_thdados_inversor2 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<GeralNodemcuModelInversor2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
