package com.api.nodemcu.controllers.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.controle.OperationModelControle;
import com.api.nodemcu.model.controle.RealizadoHorariaTabletModelControle;
import com.api.nodemcu.repository.controle.OperationRepositoryControle;
import com.api.nodemcu.repository.controle.RealizadoHorariaTabletRepositoryControle;


@RestController
@RequestMapping("/api/v1/realizadoHorariaTablet_controle")
public class RealizadoHorariaTabletControllerControle {
    @Autowired
    private RealizadoHorariaTabletRepositoryControle repository;

    @Autowired
    private OperationRepositoryControle operationRepository;

    @GetMapping()
    List<RealizadoHorariaTabletModelControle> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{name}")
    RealizadoHorariaTabletModelControle findByNameId(@PathVariable String name){
        OperationModelControle operation = operationRepository.findByName(name);
        return repository.findByNameId(operation);
    }


    @PostMapping()
    RealizadoHorariaTabletModelControle post(@RequestBody RealizadoHorariaTabletModelControle realizado){
        return repository.save(realizado);
    }
}
