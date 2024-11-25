package com.api.nodemcu.controllers.Inversor2;

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

import com.api.nodemcu.model.Inversor2.ControleGeralModelInversor2;
import com.api.nodemcu.model.inversor1.ControleGeralModelInversor1;
import com.api.nodemcu.model.inversor1.MainModelInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.repository.Inversor1.ControleGeralRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.ControleGeralRepositoryInversor2;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
@RequestMapping("/api/v1/geral_inversor2")
public class ControleGeralControllerInversor2 {

    @Autowired
    ControleGeralRepositoryInversor2 controleGeralRepository;

    @GetMapping()
    public List<ControleGeralModelInversor2> listAll() {
        return controleGeralRepository.findAll();
    }

    @PostMapping()
    public ControleGeralModelInversor2 post(@RequestBody ControleGeralModelInversor2 item) {
        controleGeralRepository.save(item);
        return item;
    }

    @GetMapping("/filterByDate")
    public List<ControleGeralModelInversor2> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return controleGeralRepository.findByDataBetween(startDate, endDate);
    }

}
