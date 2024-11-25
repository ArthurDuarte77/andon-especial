package com.api.nodemcu.controllers.controle;


import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.controle.FontesModelControle;
import com.api.nodemcu.repository.controle.FontesRepositoryControle;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fonte_controle")
public class FontesControllerControle {

    @Autowired
    FontesRepositoryControle repository;

    @GetMapping()
    public List<FontesModelControle> listAll() {
        List<FontesModelControle> fontes = repository.findAll();
        return fontes;
    }

    @GetMapping("/isCurrent")
    public FontesModelControle findByIsCurrent() {
        List<FontesModelControle> fontes = repository.findAll();

        for(FontesModelControle fonte: fontes){
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
            FontesModelControle fontes = repository.findBymodelo(modelo);
            fontes.setIs_current(isCurrent);
            repository.save(fontes);
        }
    }

    @PostMapping()
    public FontesModelControle post(@RequestBody FontesModelControle fonte) {
        return repository.save(fonte);
    }

}