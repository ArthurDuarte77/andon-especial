package com.api.nodemcu.controllers.Inversor1;

import com.api.nodemcu.model.inversor1.FontesModelInversor1;
import com.api.nodemcu.model.inversor1.PausaModelInversor1;
import com.api.nodemcu.repository.Inversor1.PausaRepositoryInversor1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pausa_inversor1")
public class PausaControllerInversor1 {

    @Autowired
    private PausaRepositoryInversor1 pausaRepository;


    @GetMapping()
    List<PausaModelInversor1> getAll(){
        return pausaRepository.findAll();
    }

    @PostMapping()
    public PausaModelInversor1 post(@RequestBody PausaModelInversor1 pausa) {
        return pausaRepository.save(pausa);
    }

}
