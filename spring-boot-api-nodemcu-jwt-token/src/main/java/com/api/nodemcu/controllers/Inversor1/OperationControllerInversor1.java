package com.api.nodemcu.controllers.Inversor1;

import com.api.nodemcu.model.inversor1.ContadorInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.repository.Inversor1.NodemcuRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.OperationRepositoryInversor1;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/operation_inversor1")
public class OperationControllerInversor1 {

    @Autowired
    OperationRepositoryInversor1 repository;

    @Autowired
    NodemcuRepositoryInversor1 nodemcuRepository;

    @Autowired
    ContadorControllerInversor1 contadorController;

    @PostMapping()
    public OperationModelInversor1 post(@RequestBody OperationModelInversor1 operation) {
        repository.save(operation);
        return operation;
    }

    @GetMapping()
    public List<OperationModelInversor1> getAll(){
        return repository.findAll();
    }


    @GetMapping("/{name}")
    public OperationModelInversor1 getByName(@PathVariable String name) {
        if(name != ""){
            return repository.findByName(name);
        }
        return new OperationModelInversor1();
    }


    @Transactional
    @GetMapping("/{name}/{ocupado}")
    public ResponseEntity<String> updateOcupadoByName(@PathVariable String name, @PathVariable Boolean ocupado) {
        OperationModelInversor1 operation = repository.findByName(name);
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
            List<NodemcuModelInversor1> nodemcu = nodemcuRepository.findAll();
            for (NodemcuModelInversor1 item : nodemcu) {
                item.setState("verde");
                contadorController.atualizarTempo(item.getContador().getId(), false);
                ContadorInversor1 novoContador = item.getContador();
                novoContador.setContadorAtual(0);
                novoContador.setIs_couting(false);
                item.setContador(novoContador);
                nodemcuRepository.save(item);
            }
            List<OperationModelInversor1> operation = repository.findAll();
            for (OperationModelInversor1 op : operation) {
                op.setPausa(pausa);
                repository.save(op);
            }
        }

    }
    @Transactional
    @GetMapping("/analise/{name}/{analise}")
    public void updateAnalise(@PathVariable String name, @PathVariable Boolean analise){
        OperationModelInversor1 operation = repository.findByName(name);
        NodemcuModelInversor1 nodemcu = nodemcuRepository.findByNameId(operation);
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