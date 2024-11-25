package com.api.nodemcu.repository.amplificador2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador2.VideoModelAmplificador2;



public interface VideoRepositoryAmplificador2 extends JpaRepository<VideoModelAmplificador2, Integer>{
    List<VideoModelAmplificador2> findAll();


    <PausaMod extends VideoModelAmplificador2> PausaMod save(PausaMod pausa);

        
    @Query(value="SELECT * FROM video_amplificador2  WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<VideoModelAmplificador2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
