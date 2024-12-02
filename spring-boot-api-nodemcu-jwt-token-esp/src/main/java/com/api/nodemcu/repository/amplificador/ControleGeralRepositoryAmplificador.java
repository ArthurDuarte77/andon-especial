package com.api.nodemcu.repository.amplificador;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador.ControleGeralModelAmplificador;



public interface ControleGeralRepositoryAmplificador extends JpaRepository<ControleGeralModelAmplificador, Integer>{

    List<ControleGeralModelAmplificador> findAll();

    Optional<ControleGeralModelAmplificador> findById(Integer id);

    <ControleGeralMod extends ControleGeralModelAmplificador> ControleGeralMod save(ControleGeralMod nodemcu);
    
    @Query(value="SELECT * FROM geral_amplificador WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<ControleGeralModelAmplificador> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
