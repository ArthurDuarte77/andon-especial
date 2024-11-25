package com.api.nodemcu.controllers.amplificador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.amplificador.OperationModelAmplificador;
import com.api.nodemcu.model.amplificador.VideoReproducaoModelAmplificador;
import com.api.nodemcu.repository.amplificador.OperationRepositoryAmplificador;
import com.api.nodemcu.repository.amplificador.VideoReproducaoRepositoryAmplificador;




@RestController
@RequestMapping("/api/v1/video_amplificador")
public class VideoReproducaoControllerAmplificador {
    
    @Autowired
    private VideoReproducaoRepositoryAmplificador videoReproducaoRepository;
    
    @Autowired
    private OperationRepositoryAmplificador operationRepository;

    @GetMapping()
    public List<VideoReproducaoModelAmplificador> getAll(){
        return videoReproducaoRepository.findAll();
    }

    @PostMapping()
    VideoReproducaoModelAmplificador post(@RequestBody VideoReproducaoModelAmplificador video){
        return videoReproducaoRepository.save(video);
    }

    @GetMapping("/{name}")
    List<VideoReproducaoModelAmplificador> getByName(@PathVariable("name") String name){
        OperationModelAmplificador operation = operationRepository.findByName(name);
        return videoReproducaoRepository.findByNameId(operation);
    }

}
