package com.api.nodemcu.controllers.amplificador2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador2.GeralMainModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.GeralMainRepositoryAmplificador2;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/main_amplificador2")
public class GeralMainControllerAmplificador2 {

    @Autowired
    private GeralMainRepositoryAmplificador2 geralMainRepository;

    @GetMapping("/filterByDate")
    public List<GeralMainModelAmplificador2> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralMainRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralMainModelAmplificador2> findAll(){
        return geralMainRepository.findAll();
    }


}
