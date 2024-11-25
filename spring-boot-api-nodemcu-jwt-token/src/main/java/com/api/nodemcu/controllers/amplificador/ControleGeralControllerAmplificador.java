package com.api.nodemcu.controllers.amplificador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.amplificador.ControleGeralModelAmplificador;
import com.api.nodemcu.repository.amplificador.ControleGeralRepositoryAmplificador;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
@RequestMapping("/api/v1/geral_amplificador")
public class ControleGeralControllerAmplificador {

    @Autowired
    ControleGeralRepositoryAmplificador controleGeralRepository;

    @GetMapping()
    public List<ControleGeralModelAmplificador> listAll() {
        return controleGeralRepository.findAll();
    }

    @PostMapping()
    public ControleGeralModelAmplificador post(@RequestBody ControleGeralModelAmplificador item) {
        controleGeralRepository.save(item);
        return item;
    }

    @GetMapping("/filterByDate")
    public List<ControleGeralModelAmplificador> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return controleGeralRepository.findByDataBetween(startDate, endDate);
    }

}
