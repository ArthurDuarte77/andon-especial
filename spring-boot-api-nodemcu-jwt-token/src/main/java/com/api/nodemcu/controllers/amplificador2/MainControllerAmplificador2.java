package com.api.nodemcu.controllers.amplificador2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador2.MainModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.MainRepostoryAmplificador2;

import java.util.List;

@RestController
@RequestMapping("/api/v1/main_amplificador2")
public class MainControllerAmplificador2 {

    @Autowired
    MainRepostoryAmplificador2 repostory;

    @GetMapping()
    public List<MainModelAmplificador2> listAll(){
        return repostory.findAll();
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Integer id, @RequestBody MainModelAmplificador2 dto) {
        MainModelAmplificador2 main = repostory.findById(id).get();
        main.setImposto(dto.getImposto());
        main.setTCimposto(dto.getTCimposto());
        main.setShiftTime(dto.getShiftTime());
        main.setOp(dto.getOp());
        repostory.save(main);
    }





}
