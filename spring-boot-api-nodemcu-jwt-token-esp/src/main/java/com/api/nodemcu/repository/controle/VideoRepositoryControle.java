package com.api.nodemcu.repository.controle;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.VideoModelControle;


public interface VideoRepositoryControle extends JpaRepository<VideoModelControle, Integer>{
    List<VideoModelControle> findAll();


    <PausaMod extends VideoModelControle> PausaMod save(PausaMod pausa);

        
    @Query(value="SELECT * FROM video_controle  WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<VideoModelControle> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
