package com.api.nodemcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.nodemcu.model.Inversor2.OperationModelInversor2;
import com.api.nodemcu.model.amplificador.OperationModelAmplificador;
import com.api.nodemcu.model.amplificador2.OperationModelAmplificador2;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.repository.Inversor1.NodemcuRepositoryInversor1;
import com.api.nodemcu.repository.Inversor1.OperationRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.NodemcuRepositoryInversor2;
import com.api.nodemcu.repository.Inversor2.OperationRepositoryInversor2;
import com.api.nodemcu.repository.amplificador.NodemcuRepositoryAmplificador;
import com.api.nodemcu.repository.amplificador.OperationRepositoryAmplificador;
import com.api.nodemcu.repository.amplificador2.NodemcuRepositoryAmplificador2;
import com.api.nodemcu.repository.amplificador2.OperationRepositoryAmplificador2;
import com.api.nodemcu.repository.controle.NodemcuRepositoryControle;
import com.api.nodemcu.repository.controle.OperationRepositoryControle;

import jakarta.transaction.Transactional;

@Controller
public class NodemcuController {

    @Autowired
    private OperationRepositoryAmplificador operationRepositoryAmplificador;

    @Autowired
    private NodemcuRepositoryAmplificador nodemcuRepositoryAmplificador;

    @Autowired
    private OperationRepositoryAmplificador2 operationRepositoryAmplificador2;

    @Autowired
    private NodemcuRepositoryAmplificador2 nodemcuRepositoryAmplificador2;

    @Autowired
    private OperationRepositoryControle operationRepositoryControle;

    @Autowired
    private NodemcuRepositoryControle nodemcuRepositoryControle;

    @Autowired
    private OperationRepositoryInversor1 operationRepositoryInversor1;

    @Autowired
    private NodemcuRepositoryInversor1 nodemcuRepositoryInversor1;

    @Autowired
    private OperationRepositoryInversor2 operationRepositoryInversor2;

    @Autowired
    private NodemcuRepositoryInversor2 nodemcuRepositoryInversor2;



    private final SimpMessagingTemplate messagingTemplate;

    public NodemcuController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("/changeColor/amplificador")
    @Transactional
    @ResponseBody
    public void changeColorAmplificador(@RequestParam String op, @RequestParam String status) {
        OperationModelAmplificador operation = operationRepositoryAmplificador.findByName(op);
        try {
            nodemcuRepositoryAmplificador.updateStateByNameId(status, operation.getId());
            messagingTemplate.convertAndSend(
                    "/amplificador/" + operation.getName() + "/news",
                    status);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/changeColor/amplificador2")
    @ResponseBody
    @Transactional
    public void changeColorAmplificador2(@RequestParam String op, @RequestParam String status) {
        OperationModelAmplificador2 operation = operationRepositoryAmplificador2.findByName(op);
        try {
            nodemcuRepositoryAmplificador2.updateStateByNameId(status, operation.getId());
            messagingTemplate.convertAndSend(
                    "/amplificador2/" + operation.getName() + "/news",
                    status);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/changeColor/controle")
    @ResponseBody
    @Transactional
    public void changeColorControle2(@RequestParam String op, @RequestParam String status) {
        OperationModelAmplificador2 operation = operationRepositoryAmplificador2.findByName(op);
        try {
            nodemcuRepositoryControle.updateStateByNameId(status, operation.getId());
            messagingTemplate.convertAndSend(
                    "/controle/" + operation.getName() + "/news",
                    status);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/changeColor/gerenciaveis")
    @ResponseBody
    @Transactional
    public void changeColorGerenciaveis(@RequestParam String op, @RequestParam String status) {
        OperationModelAmplificador2 operation = operationRepositoryAmplificador2.findByName(op);
        try {
            nodemcuRepositoryAmplificador2.updateStateByNameId(status, operation.getId());
            messagingTemplate.convertAndSend(
                    "/gerenciaveis/" + operation.getName() + "/news",
                    status);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/changeColor/inversor1")
    @ResponseBody
    @Transactional
    public void changeColorInversor1(@RequestParam String op, @RequestParam String status) {
        OperationModelInversor1 operation = operationRepositoryInversor1.findByName(op);
        try {
            nodemcuRepositoryInversor1.updateStateByNameId(status, operation.getId());
            messagingTemplate.convertAndSend(
                    "/inversor1/" + operation.getName() + "/news",
                    status);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/changeColor/inversor2")
    @ResponseBody
    @Transactional
    public void changeColorInversor2(@RequestParam String op, @RequestParam String status) {
        OperationModelInversor2 operation = operationRepositoryInversor2.findByName(op);
        try {
            nodemcuRepositoryInversor2.updateStateByNameId(status, operation.getId());
            messagingTemplate.convertAndSend(
                    "/inversor2/" + operation.getName() + "/news",
                    status);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new RuntimeException(e);
        }
    }
}