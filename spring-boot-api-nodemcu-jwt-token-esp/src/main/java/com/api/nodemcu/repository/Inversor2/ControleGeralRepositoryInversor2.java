package com.api.nodemcu.repository.Inversor2;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.Inversor2.ControleGeralModelInversor2;

public interface ControleGeralRepositoryInversor2 extends JpaRepository<ControleGeralModelInversor2, Integer>{

    List<ControleGeralModelInversor2> findAll();

    Optional<ControleGeralModelInversor2> findById(Integer id);

    <ControleGeralMod extends ControleGeralModelInversor2> ControleGeralMod save(ControleGeralMod nodemcu);
    
    @Query(value="SELECT * FROM geral_inversor2 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<ControleGeralModelInversor2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
