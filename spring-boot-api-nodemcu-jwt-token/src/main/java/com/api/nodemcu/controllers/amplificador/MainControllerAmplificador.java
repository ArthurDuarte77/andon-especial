package com.api.nodemcu.controllers.amplificador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador.MainModelAmplificador;
import com.api.nodemcu.repository.amplificador.MainRepostoryAmplificador;

import java.util.List;

@RestController
@RequestMapping("/api/v1/main_amplificador")
public class MainControllerAmplificador {

    @Autowired
    MainRepostoryAmplificador repostory;

    @GetMapping()
    public List<MainModelAmplificador> listAll(){
        return repostory.findAll();
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Integer id, @RequestBody MainModelAmplificador dto) {
        MainModelAmplificador main = repostory.findById(id).get();
        main.setImposto(dto.getImposto());
        main.setTCimposto(dto.getTCimposto());
        main.setShiftTime(dto.getShiftTime());
        main.setOp(dto.getOp());
        repostory.save(main);
    }





}
