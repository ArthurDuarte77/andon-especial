package com.api.nodemcu.controllers.Inversor2;

import com.api.nodemcu.model.Inversor2.RealizadoHorariaModelInversor2;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.RealizadoHorariaModelInversor1;
import com.api.nodemcu.repository.Inversor1.RealizadoHorariaRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.RealizadoHorariaRepositoryInversor2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/realizadoHoraria_inversor2")
public class RealizadoHorariaControllerInversor2 {

    @Autowired
    private RealizadoHorariaRepositoryInversor2 repository;

    @GetMapping()
    List<RealizadoHorariaModelInversor2> findAll(){
        return  repository.findAll();
    }

    @PostMapping()
    RealizadoHorariaModelInversor2 post(@RequestBody RealizadoHorariaModelInversor2 item){
        return repository.save(item);
    }
}
