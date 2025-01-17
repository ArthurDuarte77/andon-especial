package com.api.nodemcu.controllers.gerenciaveis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.gerenciaveis.OperationModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.VideoReproducaoModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.OperationRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.VideoReproducaoRepositoryGerenciaveis;





@RestController
@RequestMapping("/api/v1/video_gerenciaveis")
public class VideoReproducaoControllerGerenciaveis {
    
    @Autowired
    private VideoReproducaoRepositoryGerenciaveis videoReproducaoRepository;
    
    @Autowired
    private OperationRepositoryGerenciaveis operationRepository;

    @GetMapping()
    public List<VideoReproducaoModelGerenciaveis> getAll(){
        return videoReproducaoRepository.findAll();
    }

    @PostMapping()
    VideoReproducaoModelGerenciaveis post(@RequestBody VideoReproducaoModelGerenciaveis video){
        return videoReproducaoRepository.save(video);
    }

    @GetMapping("/{name}")
    List<VideoReproducaoModelGerenciaveis> getByName(@PathVariable("name") String name){
        OperationModelGerenciaveis operation = operationRepository.findByName(name);
        return videoReproducaoRepository.findByNameId(operation);
    }

}
