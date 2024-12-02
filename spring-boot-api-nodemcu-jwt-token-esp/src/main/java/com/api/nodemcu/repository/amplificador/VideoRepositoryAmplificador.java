package com.api.nodemcu.repository.amplificador;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador.VideoModelAmplificador;



public interface VideoRepositoryAmplificador extends JpaRepository<VideoModelAmplificador, Integer>{
    List<VideoModelAmplificador> findAll();


    <PausaMod extends VideoModelAmplificador> PausaMod save(PausaMod pausa);

        
    @Query(value="SELECT * FROM video_amplificador  WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<VideoModelAmplificador> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
