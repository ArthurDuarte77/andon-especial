package com.api.nodemcu.controllers.Inversor1;

import com.api.nodemcu.model.inversor1.GeralMainModelInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;
import com.api.nodemcu.repository.Inversor1.GeralMainRepositoryInversor1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/main_inversor1")
public class GeralMainControllerInversor1 {

    @Autowired
    private GeralMainRepositoryInversor1 geralMainRepository;

    @GetMapping("/filterByDate")
    public List<GeralMainModelInversor1> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralMainRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralMainModelInversor1> findAll(){
        return geralMainRepository.findAll();
    }


}
