package com.api.nodemcu.controllers.Inversor2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.Inversor2.OperationModelInversor2;
import com.api.nodemcu.model.Inversor2.RealizadoHorariaTabletModelInversor2;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.model.inversor1.RealizadoHorariaModelInversor1;
import com.api.nodemcu.model.inversor1.RealizadoHorariaTabletModelInversor1;
import com.api.nodemcu.repository.Inversor1.OperationRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.RealizadoHorariaRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.RealizadoHorariaTabletRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.OperationRepositoryInversor2;
import com.api.nodemcu.repository.Inversor2.RealizadoHorariaTabletRepositoryInversor2;

@RestController
@RequestMapping("/api/v1/realizadoHorariaTablet_inversor2")
public class RealizadoHorariaTabletControllerInversor2 {
    @Autowired
    private RealizadoHorariaTabletRepositoryInversor2 repository;

    @Autowired
    private OperationRepositoryInversor2 operationRepository;

    @GetMapping()
    List<RealizadoHorariaTabletModelInversor2> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{name}")
    RealizadoHorariaTabletModelInversor2 findByNameId(@PathVariable String name){
        OperationModelInversor2 operation = operationRepository.findByName(name);
        return repository.findByNameId(operation);
    }


    @PostMapping()
    RealizadoHorariaTabletModelInversor2 post(@RequestBody RealizadoHorariaTabletModelInversor2 realizado){
        return repository.save(realizado);
    }
}
