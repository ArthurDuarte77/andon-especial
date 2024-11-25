package com.api.nodemcu.controllers.Inversor2;

import com.api.nodemcu.model.Inversor2.GeralMainModelInversor2;
import com.api.nodemcu.model.inversor1.GeralMainModelInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;
import com.api.nodemcu.repository.Inversor1.GeralMainRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.GeralMainRepositoryInversor2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/geral/main_inversor2")
public class GeralMainControllerInversor2 {

    @Autowired
    private GeralMainRepositoryInversor2 geralMainRepository;

    @GetMapping("/filterByDate")
    public List<GeralMainModelInversor2> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return geralMainRepository.findByDataBetween(startDate, endDate);
    }

    @GetMapping()
    public List<GeralMainModelInversor2> findAll(){
        return geralMainRepository.findAll();
    }


}
