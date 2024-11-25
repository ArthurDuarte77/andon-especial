package com.api.nodemcu.controllers.Inversor1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.model.inversor1.VideoModelInversor1;
import com.api.nodemcu.model.inversor1.VideoReproducaoModelInversor1;
import com.api.nodemcu.repository.Inversor1.OperationRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.VideoReproducaoRepositoryInversor1;


@RestController
@RequestMapping("/api/v1/video_inversor1")
public class VideoReproducaoControllerInversor1 {
    
    @Autowired
    private VideoReproducaoRepositoryInversor1 videoReproducaoRepository;
    
    @Autowired
    private OperationRepositoryInversor1 operationRepository;

    @GetMapping()
    public List<VideoReproducaoModelInversor1> getAll(){
        return videoReproducaoRepository.findAll();
    }

    @PostMapping()
    VideoReproducaoModelInversor1 post(@RequestBody VideoReproducaoModelInversor1 video){
        return videoReproducaoRepository.save(video);
    }

    @GetMapping("/{name}")
    List<VideoReproducaoModelInversor1> getByName(@PathVariable("name") String name){
        OperationModelInversor1 operation = operationRepository.findByName(name);
        return videoReproducaoRepository.findByNameId(operation);
    }

}
