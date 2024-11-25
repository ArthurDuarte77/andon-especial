package com.api.nodemcu.controllers.Inversor2;

import com.api.nodemcu.model.Inversor2.ContadorInversor2;
import com.api.nodemcu.model.Inversor2.NodemcuModelInversor2;
import com.api.nodemcu.model.Inversor2.OperationModelInversor2;
import com.api.nodemcu.model.inversor1.ContadorInversor1;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.repository.Inversor1.NodemcuRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.OperationRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.NodemcuRepositoryInversor2;
import com.api.nodemcu.repository.Inversor2.OperationRepositoryInversor2;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/operation_inversor2")
public class OperationControllerInversor2 {

    @Autowired
    OperationRepositoryInversor2 repository;

    @Autowired
    NodemcuRepositoryInversor2 nodemcuRepository;

    @Autowired
    ContadorControllerInversor2 contadorController;

    @PostMapping()
    public OperationModelInversor2 post(@RequestBody OperationModelInversor2 operation) {
        repository.save(operation);
        return operation;
    }

    @GetMapping()
    public List<OperationModelInversor2> getAll(){
        return repository.findAll();
    }


    @GetMapping("/{name}")
    public OperationModelInversor2 getByName(@PathVariable String name) {
        if(name != ""){
            return repository.findByName(name);
        }
        return new OperationModelInversor2();
    }


    @Transactional
    @GetMapping("/{name}/{ocupado}")
    public ResponseEntity<String> updateOcupadoByName(@PathVariable String name, @PathVariable Boolean ocupado) {
        OperationModelInversor2 operation = repository.findByName(name);
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
            List<NodemcuModelInversor2> nodemcu = nodemcuRepository.findAll();
            for (NodemcuModelInversor2 item : nodemcu) {
                item.setState("verde");
                contadorController.atualizarTempo(item.getContador().getId(), false);
                ContadorInversor2 novoContador = item.getContador();
                novoContador.setContadorAtual(0);
                novoContador.setIs_couting(false);
                item.setContador(novoContador);
                nodemcuRepository.save(item);
            }
            List<OperationModelInversor2> operation = repository.findAll();
            for (OperationModelInversor2 op : operation) {
                op.setPausa(pausa);
                repository.save(op);
            }
        }

    }
    @Transactional
    @GetMapping("/analise/{name}/{analise}")
    public void updateAnalise(@PathVariable String name, @PathVariable Boolean analise){
        OperationModelInversor2 operation = repository.findByName(name);
        NodemcuModelInversor2 nodemcu = nodemcuRepository.findByNameId(operation);
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