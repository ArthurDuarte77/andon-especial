package com.api.nodemcu.controllers.Inversor1;

import com.api.nodemcu.model.inversor1.ImpostoDTOInversor1;
import com.api.nodemcu.model.inversor1.MainModelInversor1;
import com.api.nodemcu.repository.Inversor1.MainRepostoryInversor1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/main_inversor1")
public class MainControllerInversor1 {

    @Autowired
    MainRepostoryInversor1 repostory;

    @GetMapping()
    public List<MainModelInversor1> listAll(){
        return repostory.findAll();
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Integer id, @RequestBody MainModelInversor1 dto) {
        MainModelInversor1 main = repostory.findById(id).get();
        main.setImposto(dto.getImposto());
        main.setTCimposto(dto.getTCimposto());
        main.setShiftTime(dto.getShiftTime());
        main.setOp(dto.getOp());
        repostory.save(main);
    }





}
