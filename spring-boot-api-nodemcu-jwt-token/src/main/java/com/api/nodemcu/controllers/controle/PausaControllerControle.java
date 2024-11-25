package com.api.nodemcu.controllers.controle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.controle.PausaModelControle;
import com.api.nodemcu.repository.controle.PausaRepositoryControle;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pausa_controle")
public class PausaControllerControle {

    @Autowired
    private PausaRepositoryControle pausaRepository;


    @GetMapping()
    List<PausaModelControle> getAll(){
        return pausaRepository.findAll();
    }

    @PostMapping()
    public PausaModelControle post(@RequestBody PausaModelControle pausa) {
        return pausaRepository.save(pausa);
    }

}
