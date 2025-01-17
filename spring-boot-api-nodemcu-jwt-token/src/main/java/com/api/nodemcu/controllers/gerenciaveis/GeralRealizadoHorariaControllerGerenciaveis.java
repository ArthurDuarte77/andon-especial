package com.api.nodemcu.controllers.gerenciaveis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.gerenciaveis.GeralRealizadoHorariaModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.GeralRealizadoHorariaRepositoryGerenciaveis;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/realizadoHoraria_gerenciaveis")
public class GeralRealizadoHorariaControllerGerenciaveis {

    @Autowired
    private GeralRealizadoHorariaRepositoryGerenciaveis geralRealizadoHorariaRepository;

    @GetMapping("/filterByDate")
    public List<GeralRealizadoHorariaModelGerenciaveis> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralRealizadoHorariaRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralRealizadoHorariaModelGerenciaveis> findAll(){
        return geralRealizadoHorariaRepository.findAll();
    }
}
