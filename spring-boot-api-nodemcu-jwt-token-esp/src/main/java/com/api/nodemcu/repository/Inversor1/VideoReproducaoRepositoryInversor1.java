package com.api.nodemcu.repository.Inversor1;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.model.inversor1.VideoReproducaoModelInversor1;

public interface VideoReproducaoRepositoryInversor1 extends JpaRepository<VideoReproducaoModelInversor1, Integer> {

    List<VideoReproducaoModelInversor1> findAll();

    <PausaMod extends VideoReproducaoModelInversor1> PausaMod save(PausaMod pausa);

    List<VideoReproducaoModelInversor1> findByNameId(OperationModelInversor1 name);

}
