package com.api.nodemcu.controllers.controle;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.controle.GeralCiclosModelControle;
import com.api.nodemcu.repository.controle.GeralCicloRepositoryControle;
import com.api.nodemcu.repository.controle.OperationRepositoryControle;


@RestController
@RequestMapping("/api/v1/geral/ciclo_controle")
public class GeralCiclosControllerControle {

    @Autowired
    private GeralCicloRepositoryControle geralCicloRepository;

    @Autowired
    private OperationRepositoryControle operationRepository;


    @GetMapping("/{name}")
    public List<GeralCiclosModelControle> getByName(@PathVariable String name){
        return geralCicloRepository.findByNameId(operationRepository.findByName(name));
    }

    @PostMapping()
    public GeralCiclosModelControle post(@RequestBody GeralCiclosModelControle device) {
        geralCicloRepository.save(device);
        return device;
    }

    @GetMapping("/filterByDate/{name}")
    public List<GeralCiclosModelControle> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @PathVariable String name) {

        return geralCicloRepository.findByDataBetween(startDate, endDate, operationRepository.findByName(name).getId());
    }

}
