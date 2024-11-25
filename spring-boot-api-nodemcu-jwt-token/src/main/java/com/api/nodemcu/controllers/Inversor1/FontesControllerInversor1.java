package com.api.nodemcu.controllers.Inversor1;

import com.api.nodemcu.model.inversor1.FontesModelInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.repository.Inversor1.FontesRepositoryInversor1;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fonte_inversor1")
public class FontesControllerInversor1 {

    @Autowired
    FontesRepositoryInversor1 repository;

    @GetMapping()
    public List<FontesModelInversor1> listAll() {
        List<FontesModelInversor1> fontes = repository.findAll();
        return fontes;
    }

    @GetMapping("/isCurrent")
    public FontesModelInversor1 findByIsCurrent() {
        List<FontesModelInversor1> fontes = repository.findAll();

        for(FontesModelInversor1 fonte: fontes){
            if (fonte.getIs_current()){
                return fonte;
            }
        }
        return fontes.get(0);
    }


    @Transactional
    @GetMapping("/{modelo}/{isCurrent}")
    public void Update(@PathVariable String modelo, @PathVariable Boolean isCurrent) {
        if(modelo != ""){
            FontesModelInversor1 fontes = repository.findBymodelo(modelo);
            fontes.setIs_current(isCurrent);
            repository.save(fontes);
        }
    }

    @PostMapping()
    public FontesModelInversor1 post(@RequestBody FontesModelInversor1 fonte) {
        return repository.save(fonte);
    }

}