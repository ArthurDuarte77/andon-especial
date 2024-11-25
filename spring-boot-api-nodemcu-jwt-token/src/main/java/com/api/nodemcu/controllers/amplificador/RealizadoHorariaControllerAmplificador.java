package com.api.nodemcu.controllers.amplificador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.amplificador.RealizadoHorariaModelAmplificador;
import com.api.nodemcu.repository.amplificador.RealizadoHorariaRepositoryAmplificador;

import java.util.List;

@RestController
@RequestMapping("/api/v1/realizadoHoraria_amplificador")
public class RealizadoHorariaControllerAmplificador {

    @Autowired
    private RealizadoHorariaRepositoryAmplificador repository;

    @GetMapping()
    List<RealizadoHorariaModelAmplificador> findAll(){
        return  repository.findAll();
    }

    @PostMapping()
    RealizadoHorariaModelAmplificador post(@RequestBody RealizadoHorariaModelAmplificador item){
        return repository.save(item);
    }
}
