package com.api.nodemcu.repository.controle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.GeralCiclosModelControle;
import com.api.nodemcu.model.controle.OperationModelControle;


public interface GeralCicloRepositoryControle extends JpaRepository<GeralCiclosModelControle, Integer>{

    List<GeralCiclosModelControle> findAll();

    List<GeralCiclosModelControle> findByNameId(OperationModelControle name_id);


    <GeralRealizado extends GeralCiclosModelControle> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_ciclo WHERE data BETWEEN :startDate AND :endDate AND name_id = :name_id", nativeQuery=true)
    List<GeralCiclosModelControle> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("name_id") Integer name_id);

}
