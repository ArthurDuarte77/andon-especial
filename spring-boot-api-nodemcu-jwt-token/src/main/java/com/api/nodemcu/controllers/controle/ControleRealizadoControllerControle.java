package com.api.nodemcu.controllers.controle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.controle.ControleRealizadoModelControle;
import com.api.nodemcu.repository.controle.ControleRealizadoRepositoryControle;

import java.util.List;
@RestController
@RequestMapping("/api/v1/realizado_controle")
public class ControleRealizadoControllerControle {

    @Autowired
    ControleRealizadoRepositoryControle controleRealizadoRepository;

    @GetMapping()
    public List<ControleRealizadoModelControle> listAll() {
        return controleRealizadoRepository.findAll();
    }

    @PostMapping()
    public ControleRealizadoModelControle post(@RequestBody ControleRealizadoModelControle item) {
        controleRealizadoRepository.save(item);
        return item;
    }


}