package com.api.nodemcu.controllers.amplificador;


import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador.FontesModelAmplificador;
import com.api.nodemcu.repository.amplificador.FontesRepositoryAmplificador;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fonte_amplificador")
public class FontesControllerAmplificador {

    @Autowired
    FontesRepositoryAmplificador repository;

    @GetMapping()
    public List<FontesModelAmplificador> listAll() {
        List<FontesModelAmplificador> fontes = repository.findAll();
        return fontes;
    }

    @GetMapping("/isCurrent")
    public FontesModelAmplificador findByIsCurrent() {
        List<FontesModelAmplificador> fontes = repository.findAll();

        for(FontesModelAmplificador fonte: fontes){
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
            FontesModelAmplificador fontes = repository.findBymodelo(modelo);
            fontes.setIs_current(isCurrent);
            repository.save(fontes);
        }
    }

    @PostMapping()
    public FontesModelAmplificador post(@RequestBody FontesModelAmplificador fonte) {
        return repository.save(fonte);
    }

}