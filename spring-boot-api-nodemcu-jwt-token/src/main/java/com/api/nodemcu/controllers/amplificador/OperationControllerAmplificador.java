package com.api.nodemcu.controllers.amplificador;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador.ContadorAmplificador;
import com.api.nodemcu.model.amplificador.NodemcuModelAmplificador;
import com.api.nodemcu.model.amplificador.OperationModelAmplificador;
import com.api.nodemcu.repository.amplificador.NodemcuRepositoryAmplificador;
import com.api.nodemcu.repository.amplificador.OperationRepositoryAmplificador;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operation_amplificador")
public class OperationControllerAmplificador {

    @Autowired
    OperationRepositoryAmplificador repository;

    @Autowired
    NodemcuRepositoryAmplificador nodemcuRepository;

    @Autowired
    ContadorControllerAmplificador contadorController;

    @PostMapping()
    public OperationModelAmplificador post(@RequestBody OperationModelAmplificador operation) {
        repository.save(operation);
        return operation;
    }

    @GetMapping()
    public List<OperationModelAmplificador> getAll(){
        return repository.findAll();
    }


    @GetMapping("/{name}")
    public OperationModelAmplificador getByName(@PathVariable String name) {
        if(name != ""){
            return repository.findByName(name);
        }
        return new OperationModelAmplificador();
    }


    @Transactional
    @GetMapping("/{name}/{ocupado}")
    public ResponseEntity<String> updateOcupadoByName(@PathVariable String name, @PathVariable Boolean ocupado) {
        OperationModelAmplificador operation = repository.findByName(name);
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
            List<NodemcuModelAmplificador> nodemcu = nodemcuRepository.findAll();
            for (NodemcuModelAmplificador item : nodemcu) {
                item.setState("verde");
                contadorController.atualizarTempo(item.getContador().getId(), false);
                ContadorAmplificador novoContador = item.getContador();
                novoContador.setContadorAtual(0);
                novoContador.setIs_couting(false);
                item.setContador(novoContador);
                nodemcuRepository.save(item);
            }
            List<OperationModelAmplificador> operation = repository.findAll();
            for (OperationModelAmplificador op : operation) {
                op.setPausa(pausa);
                repository.save(op);
            }
        }

    }
    @Transactional
    @GetMapping("/analise/{name}/{analise}")
    public void updateAnalise(@PathVariable String name, @PathVariable Boolean analise){
        OperationModelAmplificador operation = repository.findByName(name);
        NodemcuModelAmplificador nodemcu = nodemcuRepository.findByNameId(operation);
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