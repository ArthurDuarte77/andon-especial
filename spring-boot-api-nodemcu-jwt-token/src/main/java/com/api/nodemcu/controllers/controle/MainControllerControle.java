package com.api.nodemcu.controllers.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.controle.MainModelControle;
import com.api.nodemcu.repository.controle.MainRepostoryControle;

import java.util.List;

@RestController
@RequestMapping("/api/v1/main_controle")
public class MainControllerControle {

    @Autowired
    MainRepostoryControle repostory;

    @GetMapping()
    public List<MainModelControle> listAll(){
        return repostory.findAll();
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Integer id, @RequestBody MainModelControle dto) {
        MainModelControle main = repostory.findById(id).get();
        main.setImposto(dto.getImposto());
        main.setTCimposto(dto.getTCimposto());
        main.setShiftTime(dto.getShiftTime());
        main.setOp(dto.getOp());
        repostory.save(main);
    }





}
