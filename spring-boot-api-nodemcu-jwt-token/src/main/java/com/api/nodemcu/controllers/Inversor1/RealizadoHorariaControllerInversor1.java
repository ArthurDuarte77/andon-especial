package com.api.nodemcu.controllers.Inversor1;

import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.RealizadoHorariaModelInversor1;
import com.api.nodemcu.repository.Inversor1.RealizadoHorariaRepositoryInversor1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/realizadoHoraria_inversor1")
public class RealizadoHorariaControllerInversor1 {

    @Autowired
    private RealizadoHorariaRepositoryInversor1 repository;

    @GetMapping()
    List<RealizadoHorariaModelInversor1> findAll(){
        return  repository.findAll();
    }

    @PostMapping()
    RealizadoHorariaModelInversor1 post(@RequestBody RealizadoHorariaModelInversor1 item){
        return repository.save(item);
    }
}
