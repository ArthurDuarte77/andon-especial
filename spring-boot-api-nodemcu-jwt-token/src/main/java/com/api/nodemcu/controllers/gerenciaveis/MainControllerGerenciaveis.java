package com.api.nodemcu.controllers.gerenciaveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.gerenciaveis.MainModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.MainRepostoryGerenciaveis;

import java.util.List;

@RestController
@RequestMapping("/api/v1/main_gerenciaveis")
public class MainControllerGerenciaveis {

    @Autowired
    MainRepostoryGerenciaveis repostory;

    @GetMapping()
    public List<MainModelGerenciaveis> listAll(){
        return repostory.findAll();
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Integer id, @RequestBody MainModelGerenciaveis dto) {
        MainModelGerenciaveis main = repostory.findById(id).get();
        main.setImposto(dto.getImposto());
        main.setTCimposto(dto.getTCimposto());
        main.setShiftTime(dto.getShiftTime());
        main.setOp(dto.getOp());
        repostory.save(main);
    }





}
