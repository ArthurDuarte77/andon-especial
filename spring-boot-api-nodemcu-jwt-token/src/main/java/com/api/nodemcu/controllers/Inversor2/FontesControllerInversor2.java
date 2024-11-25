package com.api.nodemcu.controllers.Inversor2;

import com.api.nodemcu.model.Inversor2.FontesModelInversor2;
import com.api.nodemcu.model.inversor1.FontesModelInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.repository.Inversor1.FontesRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.FontesRepositoryInversor2;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fonte_inversor2")
public class FontesControllerInversor2 {

    @Autowired
    FontesRepositoryInversor2 repository;

    @GetMapping()
    public List<FontesModelInversor2> listAll() {
        List<FontesModelInversor2> fontes = repository.findAll();
        return fontes;
    }

    @GetMapping("/isCurrent")
    public FontesModelInversor2 findByIsCurrent() {
        List<FontesModelInversor2> fontes = repository.findAll();

        for(FontesModelInversor2 fonte: fontes){
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
            FontesModelInversor2 fontes = repository.findBymodelo(modelo);
            fontes.setIs_current(isCurrent);
            repository.save(fontes);
        }
    }

    @PostMapping()
    public FontesModelInversor2 post(@RequestBody FontesModelInversor2 fonte) {
        return repository.save(fonte);
    }

}