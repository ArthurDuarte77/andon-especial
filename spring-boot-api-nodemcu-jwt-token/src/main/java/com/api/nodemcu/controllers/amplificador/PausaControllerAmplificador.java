package com.api.nodemcu.controllers.amplificador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador.PausaModelAmplificador;
import com.api.nodemcu.repository.amplificador.PausaRepositoryAmplificador;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pausa_amplificador")
public class PausaControllerAmplificador {

    @Autowired
    private PausaRepositoryAmplificador pausaRepository;


    @GetMapping()
    List<PausaModelAmplificador> getAll(){
        return pausaRepository.findAll();
    }

    @PostMapping()
    public PausaModelAmplificador post(@RequestBody PausaModelAmplificador pausa) {
        return pausaRepository.save(pausa);
    }

}
