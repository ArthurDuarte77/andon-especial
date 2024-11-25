package com.api.nodemcu.controllers.Inversor2;

import com.api.nodemcu.model.Inversor2.MainModelInversor2;
import com.api.nodemcu.model.inversor1.ImpostoDTOInversor1;
import com.api.nodemcu.model.inversor1.MainModelInversor1;
import com.api.nodemcu.repository.Inversor1.MainRepostoryInversor1;
import com.api.nodemcu.repository.Inversor2.MainRepostoryInversor2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/main_inversor2")
public class MainControllerInversor2 {

    @Autowired
    MainRepostoryInversor2 repostory;

    @GetMapping()
    public List<MainModelInversor2> listAll(){
        return repostory.findAll();
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Integer id, @RequestBody MainModelInversor2 dto) {
        MainModelInversor2 main = repostory.findById(id).get();
        main.setImposto(dto.getImposto());
        main.setTCimposto(dto.getTCimposto());
        main.setShiftTime(dto.getShiftTime());
        main.setOp(dto.getOp());
        repostory.save(main);
    }





}
