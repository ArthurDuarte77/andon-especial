package com.api.nodemcu.controllers.gerenciaveis;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.gerenciaveis.ContadorGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.NodemcuModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.OperationModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.NodemcuRepositoryGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.OperationRepositoryGerenciaveis;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operation_gerenciaveis")
public class OperationControllerGerenciaveis {

    @Autowired
    OperationRepositoryGerenciaveis repository;

    @Autowired
    NodemcuRepositoryGerenciaveis nodemcuRepository;

    @Autowired
    ContadorControllerGerenciaveis contadorController;

    @PostMapping()
    public OperationModelGerenciaveis post(@RequestBody OperationModelGerenciaveis operation) {
        repository.save(operation);
        return operation;
    }

    @GetMapping()
    public List<OperationModelGerenciaveis> getAll(){
        return repository.findAll();
    }


    @GetMapping("/{name}")
    public OperationModelGerenciaveis getByName(@PathVariable String name) {
        if(name != ""){
            return repository.findByName(name);
        }
        return new OperationModelGerenciaveis();
    }


    @Transactional
    @GetMapping("/{name}/{ocupado}")
    public ResponseEntity<String> updateOcupadoByName(@PathVariable String name, @PathVariable Boolean ocupado) {
        OperationModelGerenciaveis operation = repository.findByName(name);
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
            List<NodemcuModelGerenciaveis> nodemcu = nodemcuRepository.findAll();
            for (NodemcuModelGerenciaveis item : nodemcu) {
                item.setState("verde");
                contadorController.atualizarTempo(item.getContador().getId(), false);
                ContadorGerenciaveis novoContador = item.getContador();
                novoContador.setContadorAtual(0);
                novoContador.setIs_couting(false);
                item.setContador(novoContador);
                nodemcuRepository.save(item);
            }
            List<OperationModelGerenciaveis> operation = repository.findAll();
            for (OperationModelGerenciaveis op : operation) {
                op.setPausa(pausa);
                repository.save(op);
            }
        }

    }
    @Transactional
    @GetMapping("/analise/{name}/{analise}")
    public void updateAnalise(@PathVariable String name, @PathVariable Boolean analise){
        OperationModelGerenciaveis operation = repository.findByName(name);
        NodemcuModelGerenciaveis nodemcu = nodemcuRepository.findByNameId(operation);
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