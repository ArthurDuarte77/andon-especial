package com.api.nodemcu.controllers.controle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.controle.GeralMainModelControle;
import com.api.nodemcu.repository.controle.GeralMainRepositoryControle;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/main_controle")
public class GeralMainControllerControle {

    @Autowired
    private GeralMainRepositoryControle geralMainRepository;

    @GetMapping("/filterByDate")
    public List<GeralMainModelControle> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralMainRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralMainModelControle> findAll(){
        return geralMainRepository.findAll();
    }


}
