package com.api.nodemcu.controllers.gerenciaveis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.gerenciaveis.OperationModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.RealizadoHorariaTabletModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.OperationRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.RealizadoHorariaTabletRepositoryGerenciaveis;



@RestController
@RequestMapping("/api/v1/realizadoHorariaTablet_gerenciaveis")
public class RealizadoHorariaTabletControllerGerenciaveis {
    @Autowired
    private RealizadoHorariaTabletRepositoryGerenciaveis repository;

    @Autowired
    private OperationRepositoryGerenciaveis operationRepository;

    @GetMapping()
    List<RealizadoHorariaTabletModelGerenciaveis> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{name}")
    RealizadoHorariaTabletModelGerenciaveis findByNameId(@PathVariable String name){
        OperationModelGerenciaveis operation = operationRepository.findByName(name);
        return repository.findByNameId(operation);
    }


    @PostMapping()
    RealizadoHorariaTabletModelGerenciaveis post(@RequestBody RealizadoHorariaTabletModelGerenciaveis realizado){
        return repository.save(realizado);
    }
}
