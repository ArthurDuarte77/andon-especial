package com.api.nodemcu.repository.Inversor1;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.inversor1.ControleGeralModelInversor1;
import com.api.nodemcu.model.inversor1.GeralMainModelInversor1;

public interface ControleGeralRepositoryInversor1 extends JpaRepository<ControleGeralModelInversor1, Integer>{

    List<ControleGeralModelInversor1> findAll();

    Optional<ControleGeralModelInversor1> findById(Integer id);

    <ControleGeralMod extends ControleGeralModelInversor1> ControleGeralMod save(ControleGeralMod nodemcu);
    
    @Query(value="SELECT * FROM geral_inversor1 WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<ControleGeralModelInversor1> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    
}
