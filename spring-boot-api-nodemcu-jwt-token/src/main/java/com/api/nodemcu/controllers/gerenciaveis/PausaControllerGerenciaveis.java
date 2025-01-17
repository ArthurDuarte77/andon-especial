package com.api.nodemcu.controllers.gerenciaveis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.controle.PausaModelControle;
import com.api.nodemcu.model.gerenciaveis.PausaModelGerenciaveis;
import com.api.nodemcu.repository.controle.PausaRepositoryControle;
import com.api.nodemcu.repository.gerenciaveis.PausaRepositoryGerenciaveis;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pausa_gerenciaveis")
public class PausaControllerGerenciaveis {

    @Autowired
    private PausaRepositoryGerenciaveis pausaRepository;


    @GetMapping()
    List<PausaModelGerenciaveis> getAll(){
        return pausaRepository.findAll();
    }

    @PostMapping()
    public PausaModelGerenciaveis post(@RequestBody PausaModelGerenciaveis pausa) {
        return pausaRepository.save(pausa);
    }

}
