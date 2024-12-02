package com.api.nodemcu.repository.Inversor1;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaModelInversor1;
import com.api.nodemcu.model.inversor1.PausaModelInversor1;
import com.api.nodemcu.model.inversor1.VideoModelInversor1;

public interface VideoRepositoryInversor1 extends JpaRepository<VideoModelInversor1, Integer>{
    List<VideoModelInversor1> findAll();


    <PausaMod extends VideoModelInversor1> PausaMod save(PausaMod pausa);

        
    @Query(value="SELECT * FROM video_inversor1  WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<VideoModelInversor1> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
