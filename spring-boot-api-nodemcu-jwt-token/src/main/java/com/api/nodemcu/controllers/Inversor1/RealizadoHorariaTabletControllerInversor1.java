package com.api.nodemcu.controllers.Inversor1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.model.inversor1.RealizadoHorariaModelInversor1;
import com.api.nodemcu.model.inversor1.RealizadoHorariaTabletModelInversor1;
import com.api.nodemcu.repository.Inversor1.OperationRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.RealizadoHorariaRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.RealizadoHorariaTabletRepositoryInversor1;

@RestController
@RequestMapping("/api/v1/realizadoHorariaTablet_inversor1")
public class RealizadoHorariaTabletControllerInversor1 {
    @Autowired
    private RealizadoHorariaTabletRepositoryInversor1 repository;

    @Autowired
    private OperationRepositoryInversor1 operationRepository;

    @GetMapping()
    List<RealizadoHorariaTabletModelInversor1> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{name}")
    RealizadoHorariaTabletModelInversor1 findByNameId(@PathVariable String name){
        OperationModelInversor1 operation = operationRepository.findByName(name);
        return repository.findByNameId(operation);
    }


    @PostMapping()
    RealizadoHorariaTabletModelInversor1 post(@RequestBody RealizadoHorariaTabletModelInversor1 realizado){
        return repository.save(realizado);
    }
}
