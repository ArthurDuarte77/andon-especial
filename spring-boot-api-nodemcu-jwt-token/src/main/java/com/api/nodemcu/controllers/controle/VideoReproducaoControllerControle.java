package com.api.nodemcu.controllers.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.controle.OperationModelControle;
import com.api.nodemcu.model.controle.VideoReproducaoModelControle;
import com.api.nodemcu.repository.controle.OperationRepositoryControle;
import com.api.nodemcu.repository.controle.VideoReproducaoRepositoryControle;




@RestController
@RequestMapping("/api/v1/video_controle")
public class VideoReproducaoControllerControle {
    
    @Autowired
    private VideoReproducaoRepositoryControle videoReproducaoRepository;
    
    @Autowired
    private OperationRepositoryControle operationRepository;

    @GetMapping()
    public List<VideoReproducaoModelControle> getAll(){
        return videoReproducaoRepository.findAll();
    }

    @PostMapping()
    VideoReproducaoModelControle post(@RequestBody VideoReproducaoModelControle video){
        return videoReproducaoRepository.save(video);
    }

    @GetMapping("/{name}")
    List<VideoReproducaoModelControle> getByName(@PathVariable("name") String name){
        OperationModelControle operation = operationRepository.findByName(name);
        return videoReproducaoRepository.findByNameId(operation);
    }

}
