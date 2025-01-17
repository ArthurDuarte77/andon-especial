package com.api.nodemcu.controllers.gerenciaveis;


import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.gerenciaveis.FontesModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.FontesRepositoryGerenciaveis;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fonte_gerenciaveis")
public class FontesControllerGerenciaveis {

    @Autowired
    FontesRepositoryGerenciaveis repository;

    @GetMapping()
    public List<FontesModelGerenciaveis> listAll() {
        List<FontesModelGerenciaveis> fontes = repository.findAll();
        return fontes;
    }

    @GetMapping("/isCurrent")
    public FontesModelGerenciaveis findByIsCurrent() {
        List<FontesModelGerenciaveis> fontes = repository.findAll();

        for(FontesModelGerenciaveis fonte: fontes){
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
            FontesModelGerenciaveis fontes = repository.findBymodelo(modelo);
            fontes.setIs_current(isCurrent);
            repository.save(fontes);
        }
    }

    @PostMapping()
    public FontesModelGerenciaveis post(@RequestBody FontesModelGerenciaveis fonte) {
        return repository.save(fonte);
    }

}