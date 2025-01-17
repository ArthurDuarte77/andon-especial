package com.api.nodemcu.controllers.gerenciaveis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.gerenciaveis.ControleRealizadoModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.ControleRealizadoRepositoryGerenciaveis;

import java.util.List;
@RestController
@RequestMapping("/api/v1/realizado_gerenciaveis")
public class ControleRealizadoControllerGerenciaveis {

    @Autowired
    ControleRealizadoRepositoryGerenciaveis controleRealizadoRepository;

    @GetMapping()
    public List<ControleRealizadoModelGerenciaveis> listAll() {
        return controleRealizadoRepository.findAll();
    }

    @PostMapping()
    public ControleRealizadoModelGerenciaveis post(@RequestBody ControleRealizadoModelGerenciaveis item) {
        controleRealizadoRepository.save(item);
        return item;
    }


}