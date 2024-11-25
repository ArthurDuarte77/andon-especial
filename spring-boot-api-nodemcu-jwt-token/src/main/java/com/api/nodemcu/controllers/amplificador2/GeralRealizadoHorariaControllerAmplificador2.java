package com.api.nodemcu.controllers.amplificador2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador2.GeralRealizadoHorariaModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.GeralRealizadoHorariaRepositoryAmplificador2;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/realizadoHoraria_amplificador2")
public class GeralRealizadoHorariaControllerAmplificador2 {

    @Autowired
    private GeralRealizadoHorariaRepositoryAmplificador2 geralRealizadoHorariaRepository;

    @GetMapping("/filterByDate")
    public List<GeralRealizadoHorariaModelAmplificador2> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralRealizadoHorariaRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralRealizadoHorariaModelAmplificador2> findAll(){
        return geralRealizadoHorariaRepository.findAll();
    }
}
