package com.api.nodemcu.controllers;
// veio do servidor
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.api.nodemcu.model.OperationModel;
import com.api.nodemcu.repository.NodemcuRepository;
import com.api.nodemcu.repository.OperationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class NodemcuController {

    @Autowired
    private NodemcuRepository nodemcuRepository;

    @Autowired
    private OperationRepository operationRepository;

    private final SimpMessagingTemplate messagingTemplate;

    public NodemcuController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Transactional
    @MessageMapping("/news")
    public void broadcastNews(@Payload String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = mapper.readTree(message);
        } catch (JsonMappingException e) {
            throw new JsonProcessingException("Erro ao mapear JSON") {
            };
        }

        String status = jsonNode.get("status").asText();
        String op = jsonNode.get("op").asText();
        OperationModel operation = operationRepository.findByName(op);
        try {
            nodemcuRepository.updateStateByNameId(status, operation.getId());
            messagingTemplate.convertAndSend(
                    "/user/" + operation.getName() + "/news",
                    status);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/send-news")
    @ResponseBody
    public void sendNews(@RequestParam String op, @RequestParam String status) {
        OperationModel operation = operationRepository.findByName(op);
        try {
            nodemcuRepository.updateStateByNameId(status, operation.getId());
            messagingTemplate.convertAndSend(
                    "/user/" + operation.getName() + "/news",
                    status);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new RuntimeException(e);
        }
    }
}