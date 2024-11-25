package com.api.nodemcu.controllers.controle;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.controle.ContadorControle;
import com.api.nodemcu.model.controle.NodemcuModelControle;
import com.api.nodemcu.model.controle.OperationModelControle;
import com.api.nodemcu.repository.controle.NodemcuRepositoryControle;
import com.api.nodemcu.repository.controle.OperationRepositoryControle;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operation_controle")
public class OperationControllerControle {

    @Autowired
    OperationRepositoryControle repository;

    @Autowired
    NodemcuRepositoryControle nodemcuRepository;

    @Autowired
    ContadorControllerControle contadorController;

    @PostMapping()
    public OperationModelControle post(@RequestBody OperationModelControle operation) {
        repository.save(operation);
        return operation;
    }

    @GetMapping()
    public List<OperationModelControle> getAll(){
        return repository.findAll();
    }


    @GetMapping("/{name}")
    public OperationModelControle getByName(@PathVariable String name) {
        if(name != ""){
            return repository.findByName(name);
        }
        return new OperationModelControle();
    }


    @Transactional
    @GetMapping("/{name}/{ocupado}")
    public ResponseEntity<String> updateOcupadoByName(@PathVariable String name, @PathVariable Boolean ocupado) {
        OperationModelControle operation = repository.findByName(name);
        if (operation != null) {
            repository.updateOcupadoByName(ocupado, operation.getId());
            return ResponseEntity.ok("Ocupado atualizado com sucesso para " + name);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Operação não encontrada para o nome " + name);
        }
    }

    @GetMapping("/pausa/{pausa}")
    public void updatePausa(@PathVariable Boolean pausa) {
        {
            List<NodemcuModelControle> nodemcu = nodemcuRepository.findAll();
            for (NodemcuModelControle item : nodemcu) {
                item.setState("verde");
                contadorController.atualizarTempo(item.getContador().getId(), false);
                ContadorControle novoContador = item.getContador();
                novoContador.setContadorAtual(0);
                novoContador.setIs_couting(false);
                item.setContador(novoContador);
                nodemcuRepository.save(item);
            }
            List<OperationModelControle> operation = repository.findAll();
            for (OperationModelControle op : operation) {
                op.setPausa(pausa);
                repository.save(op);
            }
        }

    }
    @Transactional
    @GetMapping("/analise/{name}/{analise}")
    public void updateAnalise(@PathVariable String name, @PathVariable Boolean analise){
        OperationModelControle operation = repository.findByName(name);
        NodemcuModelControle nodemcu = nodemcuRepository.findByNameId(operation);
        if(analise.equals(false)){
            nodemcu.setState("verde");
        }else{
            nodemcu.setAnalise(nodemcu.getAnalise() + 1);
            nodemcu.setState("azul");
        }
        nodemcuRepository.save(nodemcu);
        if (operation != null) {
            repository.updateAnaliseById(analise, operation.getId());
        }
    }


}