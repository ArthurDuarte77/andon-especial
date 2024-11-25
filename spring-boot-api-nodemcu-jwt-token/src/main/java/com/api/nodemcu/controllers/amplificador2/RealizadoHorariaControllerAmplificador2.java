package com.api.nodemcu.controllers.amplificador2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.amplificador2.RealizadoHorariaModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.RealizadoHorariaRepositoryAmplificador2;

import java.util.List;

@RestController
@RequestMapping("/api/v1/realizadoHoraria_amplificador2")
public class RealizadoHorariaControllerAmplificador2 {

    @Autowired
    private RealizadoHorariaRepositoryAmplificador2 repository;

    @GetMapping()
    List<RealizadoHorariaModelAmplificador2> findAll(){
        return  repository.findAll();
    }

    @PostMapping()
    RealizadoHorariaModelAmplificador2 post(@RequestBody RealizadoHorariaModelAmplificador2 item){
        return repository.save(item);
    }
}
