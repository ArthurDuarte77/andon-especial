package com.api.nodemcu.controllers.Inversor2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.Inversor2.OperationModelInversor2;
import com.api.nodemcu.model.Inversor2.VideoReproducaoModelInversor2;
import com.api.nodemcu.repository.Inversor2.OperationRepositoryInversor2;
import com.api.nodemcu.repository.Inversor2.VideoReproducaoRepositoryInversor2;



@RestController
@RequestMapping("/api/v1/video_inversor2")
public class VideoReproducaoControllerInversor2 {
    
    @Autowired
    private VideoReproducaoRepositoryInversor2 videoReproducaoRepository;
    
    @Autowired
    private OperationRepositoryInversor2 operationRepository;

    @GetMapping()
    public List<VideoReproducaoModelInversor2> getAll(){
        return videoReproducaoRepository.findAll();
    }

    @PostMapping()
    VideoReproducaoModelInversor2 post(@RequestBody VideoReproducaoModelInversor2 video){
        return videoReproducaoRepository.save(video);
    }

    @GetMapping("/{name}")
    List<VideoReproducaoModelInversor2> getByName(@PathVariable("name") String name){
        OperationModelInversor2 operation = operationRepository.findByName(name);
        return videoReproducaoRepository.findByNameId(operation);
    }

}
