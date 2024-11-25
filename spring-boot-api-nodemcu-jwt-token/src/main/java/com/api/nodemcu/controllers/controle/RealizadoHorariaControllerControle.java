package com.api.nodemcu.controllers.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.controle.RealizadoHorariaModelControle;
import com.api.nodemcu.repository.controle.RealizadoHorariaRepositoryControle;

import java.util.List;

@RestController
@RequestMapping("/api/v1/realizadoHoraria_controle")
public class RealizadoHorariaControllerControle {

    @Autowired
    private RealizadoHorariaRepositoryControle repository;

    @GetMapping()
    List<RealizadoHorariaModelControle> findAll(){
        return  repository.findAll();
    }

    @PostMapping()
    RealizadoHorariaModelControle post(@RequestBody RealizadoHorariaModelControle item){
        return repository.save(item);
    }
}
