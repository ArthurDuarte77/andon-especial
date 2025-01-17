package com.api.nodemcu.controllers.gerenciaveis;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.gerenciaveis.GeralCiclosModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.GeralCicloRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.OperationRepositoryGerenciaveis;



@RestController
@RequestMapping("/api/v1/geral/ciclo_gerenciaveis")
public class GeralCiclosControllerGerenciaveis {

    @Autowired
    private GeralCicloRepositoryGerenciaveis geralCicloRepository;

    @Autowired
    private OperationRepositoryGerenciaveis operationRepository;


    @GetMapping("/{name}")
    public List<GeralCiclosModelGerenciaveis> getByName(@PathVariable String name){
        return geralCicloRepository.findByNameId(operationRepository.findByName(name));
    }

    @PostMapping()
    public GeralCiclosModelGerenciaveis post(@RequestBody GeralCiclosModelGerenciaveis device) {
        geralCicloRepository.save(device);
        return device;
    }

    @GetMapping("/filterByDate/{name}")
    public List<GeralCiclosModelGerenciaveis> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @PathVariable String name) {

        return geralCicloRepository.findByDataBetween(startDate, endDate, operationRepository.findByName(name).getId());
    }

}
