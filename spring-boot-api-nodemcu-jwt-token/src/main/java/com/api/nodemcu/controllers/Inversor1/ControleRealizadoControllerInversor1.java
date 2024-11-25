package com.api.nodemcu.controllers.Inversor1;

import com.api.nodemcu.model.inversor1.ControleGeralModelInversor1;
import com.api.nodemcu.model.inversor1.ControleRealizadoModelInversor1;
import com.api.nodemcu.repository.Inversor1.ControleGeralRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.ControleRealizadoRepositoryInversor1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/realizado_inversor1")
public class ControleRealizadoControllerInversor1 {

    @Autowired
    ControleRealizadoRepositoryInversor1 controleRealizadoRepository;

    @GetMapping()
    public List<ControleRealizadoModelInversor1> listAll() {
        return controleRealizadoRepository.findAll();
    }

    @PostMapping()
    public ControleRealizadoModelInversor1 post(@RequestBody ControleRealizadoModelInversor1 item) {
        controleRealizadoRepository.save(item);
        return item;
    }


}