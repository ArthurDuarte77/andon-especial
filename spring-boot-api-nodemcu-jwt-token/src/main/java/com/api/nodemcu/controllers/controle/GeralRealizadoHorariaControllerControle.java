package com.api.nodemcu.controllers.controle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.controle.GeralRealizadoHorariaModelControle;
import com.api.nodemcu.repository.controle.GeralRealizadoHorariaRepositoryControle;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/realizadoHoraria_controle")
public class GeralRealizadoHorariaControllerControle {

    @Autowired
    private GeralRealizadoHorariaRepositoryControle geralRealizadoHorariaRepository;

    @GetMapping("/filterByDate")
    public List<GeralRealizadoHorariaModelControle> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralRealizadoHorariaRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralRealizadoHorariaModelControle> findAll(){
        return geralRealizadoHorariaRepository.findAll();
    }
}
