package com.api.nodemcu.controllers.amplificador2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.amplificador2.OperationModelAmplificador2;
import com.api.nodemcu.model.amplificador2.VideoReproducaoModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.OperationRepositoryAmplificador2;
import com.api.nodemcu.repository.amplificador2.VideoReproducaoRepositoryAmplificador2;


@RestController
@RequestMapping("/api/v1/video_amplificador2")
public class VideoReproducaoControllerAmplificador2 {
    
    @Autowired
    private VideoReproducaoRepositoryAmplificador2 videoReproducaoRepository;
    
    @Autowired
    private OperationRepositoryAmplificador2 operationRepository;

    @GetMapping()
    public List<VideoReproducaoModelAmplificador2> getAll(){
        return videoReproducaoRepository.findAll();
    }

    @PostMapping()
    VideoReproducaoModelAmplificador2 post(@RequestBody VideoReproducaoModelAmplificador2 video){
        return videoReproducaoRepository.save(video);
    }

    @GetMapping("/{name}")
    List<VideoReproducaoModelAmplificador2> getByName(@PathVariable("name") String name){
        OperationModelAmplificador2 operation = operationRepository.findByName(name);
        return videoReproducaoRepository.findByNameId(operation);
    }

}
