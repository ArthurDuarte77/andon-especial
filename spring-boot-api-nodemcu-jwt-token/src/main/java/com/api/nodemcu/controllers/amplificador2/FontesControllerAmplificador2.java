package com.api.nodemcu.controllers.amplificador2;


import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador2.FontesModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.FontesRepositoryAmplificador2;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fonte_amplificador2")
public class FontesControllerAmplificador2 {

    @Autowired
    FontesRepositoryAmplificador2 repository;

    @GetMapping()
    public List<FontesModelAmplificador2> listAll() {
        List<FontesModelAmplificador2> fontes = repository.findAll();
        return fontes;
    }

    @GetMapping("/isCurrent")
    public FontesModelAmplificador2 findByIsCurrent() {
        List<FontesModelAmplificador2> fontes = repository.findAll();

        for(FontesModelAmplificador2 fonte: fontes){
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
            FontesModelAmplificador2 fontes = repository.findBymodelo(modelo);
            fontes.setIs_current(isCurrent);
            repository.save(fontes);
        }
    }

    @PostMapping()
    public FontesModelAmplificador2 post(@RequestBody FontesModelAmplificador2 fonte) {
        return repository.save(fonte);
    }

}