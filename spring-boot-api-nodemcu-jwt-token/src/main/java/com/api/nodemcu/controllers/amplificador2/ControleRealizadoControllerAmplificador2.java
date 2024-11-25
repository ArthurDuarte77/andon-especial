package com.api.nodemcu.controllers.amplificador2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador2.ControleRealizadoModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.ControleRealizadoRepositoryAmplificador2;

import java.util.List;

@RestController
@RequestMapping("/api/v1/realizado_amplificador2")
public class ControleRealizadoControllerAmplificador2 {

    @Autowired
    ControleRealizadoRepositoryAmplificador2 controleRealizadoRepository;

    @GetMapping()
    public List<ControleRealizadoModelAmplificador2> listAll() {
        return controleRealizadoRepository.findAll();
    }

    @PostMapping()
    public ControleRealizadoModelAmplificador2 post(@RequestBody ControleRealizadoModelAmplificador2 item) {
        controleRealizadoRepository.save(item);
        return item;
    }


}