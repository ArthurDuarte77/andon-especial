package com.api.nodemcu.repository.controle;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.ControleGeralModelControle;


public interface ControleGeralRepositoryControle extends JpaRepository<ControleGeralModelControle, Integer>{

    List<ControleGeralModelControle> findAll();

    Optional<ControleGeralModelControle> findById(Integer id);

    <ControleGeralMod extends ControleGeralModelControle> ControleGeralMod save(ControleGeralMod nodemcu);
    
    @Query(value="SELECT * FROM geral_controle WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<ControleGeralModelControle> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
