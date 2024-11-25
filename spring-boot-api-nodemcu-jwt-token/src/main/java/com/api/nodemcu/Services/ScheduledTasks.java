package com.api.nodemcu.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.api.nodemcu.controllers.Inversor1.ContadorControllerInversor1;
import com.api.nodemcu.model.inversor1.ContadorInversor1;
import com.api.nodemcu.repository.Inversor1.ContadorRepositoryInversor1;

@Configuration
@EnableScheduling
public class ScheduledTasks {

    @Autowired
    private ContadorRepositoryInversor1 contadorRepository;

    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        // Incrementa todos os contadores a cada segundo
        for (ContadorInversor1 contador : contadorRepository.findAll()) {
            contador.setContadorAtual(contador.getContadorAtual() + 1);
        }
    }
}


