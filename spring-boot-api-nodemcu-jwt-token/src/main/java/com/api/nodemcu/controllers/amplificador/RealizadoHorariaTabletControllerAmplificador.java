package com.api.nodemcu.controllers.amplificador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.amplificador.OperationModelAmplificador;
import com.api.nodemcu.model.amplificador.RealizadoHorariaTabletModelAmplificador;
import com.api.nodemcu.repository.amplificador.OperationRepositoryAmplificador;
import com.api.nodemcu.repository.amplificador.RealizadoHorariaTabletRepositoryAmplificador;



@RestController
@RequestMapping("/api/v1/realizadoHorariaTablet_amplificador")
public class RealizadoHorariaTabletControllerAmplificador {
    @Autowired
    private RealizadoHorariaTabletRepositoryAmplificador repository;

    @Autowired
    private OperationRepositoryAmplificador operationRepository;

    @GetMapping()
    List<RealizadoHorariaTabletModelAmplificador> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{name}")
    RealizadoHorariaTabletModelAmplificador findByNameId(@PathVariable String name){
        OperationModelAmplificador operation = operationRepository.findByName(name);
        return repository.findByNameId(operation);
    }


    @PostMapping()
    RealizadoHorariaTabletModelAmplificador post(@RequestBody RealizadoHorariaTabletModelAmplificador realizado){
        return repository.save(realizado);
    }
}
