package com.api.nodemcu.controllers.amplificador2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.amplificador2.OperationModelAmplificador2;
import com.api.nodemcu.model.amplificador2.RealizadoHorariaTabletModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.OperationRepositoryAmplificador2;
import com.api.nodemcu.repository.amplificador2.RealizadoHorariaTabletRepositoryAmplificador2;




@RestController
@RequestMapping("/api/v1/realizadoHorariaTablet_amplificador2")
public class RealizadoHorariaTabletControllerAmplificador2 {
    @Autowired
    private RealizadoHorariaTabletRepositoryAmplificador2 repository;

    @Autowired
    private OperationRepositoryAmplificador2 operationRepository;

    @GetMapping()
    List<RealizadoHorariaTabletModelAmplificador2> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{name}")
    RealizadoHorariaTabletModelAmplificador2 findByNameId(@PathVariable String name){
        OperationModelAmplificador2 operation = operationRepository.findByName(name);
        return repository.findByNameId(operation);
    }


    @PostMapping()
    RealizadoHorariaTabletModelAmplificador2 post(@RequestBody RealizadoHorariaTabletModelAmplificador2 realizado){
        return repository.save(realizado);
    }
}
