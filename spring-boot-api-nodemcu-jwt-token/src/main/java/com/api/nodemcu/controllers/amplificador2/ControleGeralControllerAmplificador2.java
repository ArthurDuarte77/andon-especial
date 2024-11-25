package com.api.nodemcu.controllers.amplificador2;

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

import com.api.nodemcu.model.amplificador2.ControleGeralModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.ControleGeralRepositoryAmplificador2;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
@RequestMapping("/api/v1/geral_amplificador2")
public class ControleGeralControllerAmplificador2 {

    @Autowired
    ControleGeralRepositoryAmplificador2 controleGeralRepository;

    @GetMapping()
    public List<ControleGeralModelAmplificador2> listAll() {
        return controleGeralRepository.findAll();
    }

    @PostMapping()
    public ControleGeralModelAmplificador2 post(@RequestBody ControleGeralModelAmplificador2 item) {
        controleGeralRepository.save(item);
        return item;
    }

    @GetMapping("/filterByDate")
    public List<ControleGeralModelAmplificador2> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return controleGeralRepository.findByDataBetween(startDate, endDate);
    }

}
