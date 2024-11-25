package com.api.nodemcu.controllers.controle;

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

import com.api.nodemcu.model.controle.ControleGeralModelControle;
import com.api.nodemcu.repository.controle.ControleGeralRepositoryControle;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
@RequestMapping("/api/v1/geral_controle")
public class ControleGeralControllerControle {

    @Autowired
    ControleGeralRepositoryControle controleGeralRepository;

    @GetMapping()
    public List<ControleGeralModelControle> listAll() {
        return controleGeralRepository.findAll();
    }

    @PostMapping()
    public ControleGeralModelControle post(@RequestBody ControleGeralModelControle item) {
        controleGeralRepository.save(item);
        return item;
    }

    @GetMapping("/filterByDate")
    public List<ControleGeralModelControle> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return controleGeralRepository.findByDataBetween(startDate, endDate);
    }

}
