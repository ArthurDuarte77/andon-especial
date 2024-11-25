package com.api.nodemcu.repository.Inversor2;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.Inversor2.VideoModelInversor2;
import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaModelInversor1;
import com.api.nodemcu.model.inversor1.PausaModelInversor1;
import com.api.nodemcu.model.inversor1.VideoModelInversor1;

public interface VideoRepositoryInversor2 extends JpaRepository<VideoModelInversor2, Integer>{
    List<VideoModelInversor2> findAll();


    <PausaMod extends VideoModelInversor2> PausaMod save(PausaMod pausa);

        
    @Query(value="SELECT * FROM video_inversor2  WHERE data BETWEEN :startDate AND :endDate", nativeQuery=true)
    List<VideoModelInversor2> findByDataBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
