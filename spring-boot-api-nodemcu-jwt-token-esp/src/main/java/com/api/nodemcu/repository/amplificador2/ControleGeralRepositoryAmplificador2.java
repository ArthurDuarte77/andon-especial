package com.api.nodemcu.repository.amplificador2;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador2.ControleGeralModelAmplificador2;



public interface ControleGeralRepositoryAmplificador2 extends JpaRepository<ControleGeralModelAmplificador2, Integer>{

    List<ControleGeralModelAmplificador2> findAll();

    Optional<ControleGeralModelAmplificador2> findById(Integer id);

    <ControleGeralMod extends ControleGeralModelAmplificador2> ControleGeralMod save(ControleGeralMod nodemcu);
    
    @Query(value="SELECT * FROM geral_amplificador2 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<ControleGeralModelAmplificador2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
