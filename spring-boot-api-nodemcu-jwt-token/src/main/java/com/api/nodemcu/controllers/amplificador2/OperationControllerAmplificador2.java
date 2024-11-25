package com.api.nodemcu.controllers.amplificador2;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador2.ContadorAmplificador2;
import com.api.nodemcu.model.amplificador2.NodemcuModelAmplificador2;
import com.api.nodemcu.model.amplificador2.OperationModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.NodemcuRepositoryAmplificador2;
import com.api.nodemcu.repository.amplificador2.OperationRepositoryAmplificador2;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operation_amplificador2")
public class OperationControllerAmplificador2 {

    @Autowired
    OperationRepositoryAmplificador2 repository;

    @Autowired
    NodemcuRepositoryAmplificador2 nodemcuRepository;

    @Autowired
    ContadorControllerAmplificador2 contadorController;

    @PostMapping()
    public OperationModelAmplificador2 post(@RequestBody OperationModelAmplificador2 operation) {
        repository.save(operation);
        return operation;
    }

    @GetMapping()
    public List<OperationModelAmplificador2> getAll(){
        return repository.findAll();
    }


    @GetMapping("/{name}")
    public OperationModelAmplificador2 getByName(@PathVariable String name) {
        if(name != ""){
            return repository.findByName(name);
        }
        return new OperationModelAmplificador2();
    }


    @Transactional
    @GetMapping("/{name}/{ocupado}")
    public ResponseEntity<String> updateOcupadoByName(@PathVariable String name, @PathVariable Boolean ocupado) {
        OperationModelAmplificador2 operation = repository.findByName(name);
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
            List<NodemcuModelAmplificador2> nodemcu = nodemcuRepository.findAll();
            for (NodemcuModelAmplificador2 item : nodemcu) {
                item.setState("verde");
                contadorController.atualizarTempo(item.getContador().getId(), false);
                ContadorAmplificador2 novoContador = item.getContador();
                novoContador.setContadorAtual(0);
                novoContador.setIs_couting(false);
                item.setContador(novoContador);
                nodemcuRepository.save(item);
            }
            List<OperationModelAmplificador2> operation = repository.findAll();
            for (OperationModelAmplificador2 op : operation) {
                op.setPausa(pausa);
                repository.save(op);
            }
        }

    }
    @Transactional
    @GetMapping("/analise/{name}/{analise}")
    public void updateAnalise(@PathVariable String name, @PathVariable Boolean analise){
        OperationModelAmplificador2 operation = repository.findByName(name);
        NodemcuModelAmplificador2 nodemcu = nodemcuRepository.findByNameId(operation);
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