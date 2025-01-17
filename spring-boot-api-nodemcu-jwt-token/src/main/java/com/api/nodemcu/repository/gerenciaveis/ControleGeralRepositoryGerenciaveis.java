package com.api.nodemcu.repository.gerenciaveis;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.gerenciaveis.ControleGeralModelGerenciaveis;



public interface ControleGeralRepositoryGerenciaveis extends JpaRepository<ControleGeralModelGerenciaveis, Integer>{

    List<ControleGeralModelGerenciaveis> findAll();

    Optional<ControleGeralModelGerenciaveis> findById(Integer id);

    <ControleGeralMod extends ControleGeralModelGerenciaveis> ControleGeralMod save(ControleGeralMod nodemcu);
    
    @Query(value="SELECT * FROM geral_gerenciaveis WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<ControleGeralModelGerenciaveis> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
