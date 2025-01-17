package com.api.nodemcu.controllers.gerenciaveis;

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

import com.api.nodemcu.model.gerenciaveis.ControleGeralModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.ControleGeralRepositoryGerenciaveis;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
@RequestMapping("/api/v1/geral_gerenciaveis")
public class ControleGeralControllerGerenciaveis {

    @Autowired
    ControleGeralRepositoryGerenciaveis controleGeralRepository;

    @GetMapping()
    public List<ControleGeralModelGerenciaveis> listAll() {
        return controleGeralRepository.findAll();
    }

    @PostMapping()
    public ControleGeralModelGerenciaveis post(@RequestBody ControleGeralModelGerenciaveis item) {
        controleGeralRepository.save(item);
        return item;
    }

    @GetMapping("/filterByDate")
    public List<ControleGeralModelGerenciaveis> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return controleGeralRepository.findByDataBetween(startDate, endDate);
    }

}
