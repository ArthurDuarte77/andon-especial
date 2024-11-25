package com.api.nodemcu.controllers.amplificador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador.ControleRealizadoModelAmplificador;
import com.api.nodemcu.repository.amplificador.ControleRealizadoRepositoryAmplificador;

import java.util.List;

@RestController
@RequestMapping("/api/v1/realizado_amplificador")
public class ControleRealizadoControllerAmplificador {

    @Autowired
    ControleRealizadoRepositoryAmplificador controleRealizadoRepository;

    @GetMapping()
    public List<ControleRealizadoModelAmplificador> listAll() {
        return controleRealizadoRepository.findAll();
    }

    @PostMapping()
    public ControleRealizadoModelAmplificador post(@RequestBody ControleRealizadoModelAmplificador item) {
        controleRealizadoRepository.save(item);
        return item;
    }


}