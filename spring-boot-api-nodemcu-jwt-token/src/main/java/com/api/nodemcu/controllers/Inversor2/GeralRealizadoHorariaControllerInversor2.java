package com.api.nodemcu.controllers.Inversor2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.Inversor2.GeralRealizadoHorariaModelInversor2;
import com.api.nodemcu.model.inversor1.GeralNodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.GeralRealizadoHorariaModelInversor1;
import com.api.nodemcu.repository.Inversor1.GeralRealizadoHorariaRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.GeralRealizadoHorariaRepositoryInversor2;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/realizadoHoraria_inversor2")
public class GeralRealizadoHorariaControllerInversor2 {

    @Autowired
    private GeralRealizadoHorariaRepositoryInversor2 geralRealizadoHorariaRepository;

    @GetMapping("/filterByDate")
    public List<GeralRealizadoHorariaModelInversor2> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralRealizadoHorariaRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralRealizadoHorariaModelInversor2> findAll(){
        return geralRealizadoHorariaRepository.findAll();
    }
}
