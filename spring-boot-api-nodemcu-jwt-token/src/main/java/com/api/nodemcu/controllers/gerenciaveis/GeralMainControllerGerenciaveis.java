package com.api.nodemcu.controllers.gerenciaveis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.gerenciaveis.GeralMainModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.GeralMainRepositoryGerenciaveis;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/main_gerenciaveis")
public class GeralMainControllerGerenciaveis {

    @Autowired
    private GeralMainRepositoryGerenciaveis geralMainRepository;

    @GetMapping("/filterByDate")
    public List<GeralMainModelGerenciaveis> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralMainRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralMainModelGerenciaveis> findAll(){
        return geralMainRepository.findAll();
    }


}
