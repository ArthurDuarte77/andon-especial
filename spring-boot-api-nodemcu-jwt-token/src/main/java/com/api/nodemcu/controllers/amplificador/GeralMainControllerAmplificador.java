package com.api.nodemcu.controllers.amplificador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador.GeralMainModelAmplificador;
import com.api.nodemcu.repository.amplificador.GeralMainRepositoryAmplificador;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/main_amplificador")
public class GeralMainControllerAmplificador {

    @Autowired
    private GeralMainRepositoryAmplificador geralMainRepository;

    @GetMapping("/filterByDate")
    public List<GeralMainModelAmplificador> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralMainRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralMainModelAmplificador> findAll(){
        return geralMainRepository.findAll();
    }


}
