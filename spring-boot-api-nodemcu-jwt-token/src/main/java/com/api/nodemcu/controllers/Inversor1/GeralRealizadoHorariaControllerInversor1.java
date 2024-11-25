package com.api.nodemcu.controllers.Inversor1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.inversor1.GeralNodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaModelInversor1;
import com.api.nodemcu.repository.Inversor1.GeralRealizadoHorariaRepositoryInversor1;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/realizadoHoraria_inversor1")
public class GeralRealizadoHorariaControllerInversor1 {

    @Autowired
    private GeralRealizadoHorariaRepositoryInversor1 geralRealizadoHorariaRepository;

    @GetMapping("/filterByDate")
    public List<GeralRealizadoHorariaModelInversor1> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralRealizadoHorariaRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralRealizadoHorariaModelInversor1> findAll(){
        return geralRealizadoHorariaRepository.findAll();
    }
}
