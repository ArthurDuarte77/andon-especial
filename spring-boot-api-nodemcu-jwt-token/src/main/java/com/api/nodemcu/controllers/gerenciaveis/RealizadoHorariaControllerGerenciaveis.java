package com.api.nodemcu.controllers.gerenciaveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.gerenciaveis.RealizadoHorariaModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.RealizadoHorariaRepositoryGerenciaveis;

import java.util.List;

@RestController
@RequestMapping("/api/v1/realizadoHoraria_gerenciaveis")
public class RealizadoHorariaControllerGerenciaveis {

    @Autowired
    private RealizadoHorariaRepositoryGerenciaveis repository;

    @GetMapping()
    List<RealizadoHorariaModelGerenciaveis> findAll(){
        return  repository.findAll();
    }

    @PostMapping()
    RealizadoHorariaModelGerenciaveis post(@RequestBody RealizadoHorariaModelGerenciaveis item){
        return repository.save(item);
    }
}
