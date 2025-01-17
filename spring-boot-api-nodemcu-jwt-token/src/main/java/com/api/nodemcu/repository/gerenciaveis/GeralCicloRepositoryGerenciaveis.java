package com.api.nodemcu.repository.gerenciaveis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.GeralCiclosModelControle;
import com.api.nodemcu.model.gerenciaveis.GeralCiclosModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.OperationModelGerenciaveis;


public interface GeralCicloRepositoryGerenciaveis extends JpaRepository<GeralCiclosModelGerenciaveis, Integer>{

    List<GeralCiclosModelGerenciaveis> findAll();

    List<GeralCiclosModelGerenciaveis> findByNameId(OperationModelGerenciaveis name_id);


    <GeralRealizado extends GeralCiclosModelGerenciaveis> GeralRealizado save(GeralRealizado nodemcu);

    @Query(value="SELECT * FROM geral_ciclo_gerenciaveis WHERE data BETWEEN :startDate AND :endDate AND name_id = :name_id", nativeQuery=true)
    List<GeralCiclosModelGerenciaveis> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("name_id") Integer name_id);

}
