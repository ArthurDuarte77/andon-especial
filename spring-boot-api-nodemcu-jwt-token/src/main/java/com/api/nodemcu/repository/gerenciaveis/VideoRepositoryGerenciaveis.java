package com.api.nodemcu.repository.gerenciaveis;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.VideoModelControle;
import com.api.nodemcu.model.gerenciaveis.VideoModelGerenciaveis;


public interface VideoRepositoryGerenciaveis extends JpaRepository<VideoModelGerenciaveis, Integer>{
    List<VideoModelGerenciaveis> findAll();


    <PausaMod extends VideoModelGerenciaveis> PausaMod save(PausaMod pausa);

        
    @Query(value="SELECT * FROM video_gerenciaveis  WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<VideoModelGerenciaveis> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
