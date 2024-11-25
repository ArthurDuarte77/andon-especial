package com.api.nodemcu.controllers.Inversor2;

import com.api.nodemcu.model.Inversor2.PausaModelInversor2;
import com.api.nodemcu.model.inversor1.FontesModelInversor1;
import com.api.nodemcu.model.inversor1.PausaModelInversor1;
import com.api.nodemcu.repository.Inversor1.PausaRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.PausaRepositoryInversor2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pausa_inversor2")
public class PausaControllerInversor2 {

    @Autowired
    private PausaRepositoryInversor2 pausaRepository;


    @GetMapping()
    List<PausaModelInversor2> getAll(){
        return pausaRepository.findAll();
    }

    @PostMapping()
    public PausaModelInversor2 post(@RequestBody PausaModelInversor2 pausa) {
        return pausaRepository.save(pausa);
    }

}
