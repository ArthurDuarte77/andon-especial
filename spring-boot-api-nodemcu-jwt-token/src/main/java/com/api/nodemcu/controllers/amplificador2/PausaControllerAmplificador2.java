package com.api.nodemcu.controllers.amplificador2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador2.PausaModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.PausaRepositoryAmplificador2;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pausa_amplificador2")
public class PausaControllerAmplificador2 {

    @Autowired
    private PausaRepositoryAmplificador2 pausaRepository;


    @GetMapping()
    List<PausaModelAmplificador2> getAll(){
        return pausaRepository.findAll();
    }

    @PostMapping()
    public PausaModelAmplificador2 post(@RequestBody PausaModelAmplificador2 pausa) {
        return pausaRepository.save(pausa);
    }

}
