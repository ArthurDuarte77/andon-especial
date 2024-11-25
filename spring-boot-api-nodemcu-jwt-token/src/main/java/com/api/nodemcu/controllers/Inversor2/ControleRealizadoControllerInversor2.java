package com.api.nodemcu.controllers.Inversor2;
import com.api.nodemcu.model.Inversor2.ControleRealizadoModelInversor2;
import com.api.nodemcu.model.inversor1.ControleGeralModelInversor1;
import com.api.nodemcu.model.inversor1.ControleRealizadoModelInversor1;
import com.api.nodemcu.repository.Inversor1.ControleGeralRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.ControleRealizadoRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.ControleRealizadoRepositoryInversor2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/realizado_inversor2")
public class ControleRealizadoControllerInversor2 {

    @Autowired
    ControleRealizadoRepositoryInversor2 controleRealizadoRepository;

    @GetMapping()
    public List<ControleRealizadoModelInversor2> listAll() {
        return controleRealizadoRepository.findAll();
    }

    @PostMapping()
    public ControleRealizadoModelInversor2 post(@RequestBody ControleRealizadoModelInversor2 item) {
        controleRealizadoRepository.save(item);
        return item;
    }


}