package com.api.nodemcu.controllers.amplificador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador.GeralRealizadoHorariaModelAmplificador;
import com.api.nodemcu.repository.amplificador.GeralRealizadoHorariaRepositoryAmplificador;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/realizadoHoraria_amplificador")
public class GeralRealizadoHorariaControllerAmplificador {

    @Autowired
    private GeralRealizadoHorariaRepositoryAmplificador geralRealizadoHorariaRepository;

    @GetMapping("/filterByDate")
    public List<GeralRealizadoHorariaModelAmplificador> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralRealizadoHorariaRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralRealizadoHorariaModelAmplificador> findAll(){
        return geralRealizadoHorariaRepository.findAll();
    }
}
