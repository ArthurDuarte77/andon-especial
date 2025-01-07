package com.api.nodemcu.controllers.controle;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.Services.NodemcuServiceControle;
import com.api.nodemcu.model.controle.NodemcuModelControle;


@RestController
@RequestMapping("/api/v1/nodemcu_controle")
public class NodemcuControllerControle {
    private ScheduledExecutorService scheduler;

    private final NodemcuServiceControle nodemcuService;

    @Autowired
    public NodemcuControllerControle(NodemcuServiceControle nodemcuService) {
        this.scheduler = Executors.newScheduledThreadPool(1);
        agendarTarefa();
        this.nodemcuService = nodemcuService;
    }

        private void agendarTarefa() {
        Runnable task = () -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (hour >= 20 & hour <= 21 && dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
                nodemcuService.zerarDados();
            }
        };
        // Agende a tarefa para ser executada a cada hora
        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.HOURS);
    }

    @GetMapping
    public List<NodemcuModelControle> list() {
        return nodemcuService.listAll();
    }

    @GetMapping("/{name}")
    public NodemcuModelControle findByName(@PathVariable String name) {
        return nodemcuService.findByName(name);
    }

    @GetMapping("/timeExcess/{name}")
    public void addTimeExcess(@PathVariable String name) {
         nodemcuService.addTimeExcess(name);
    }
    
    @GetMapping("/zerar")
    public void zerar() {
        nodemcuService.zerarDados();
    }

    @GetMapping("/ajuda/{name}")
    public void addAjuda(@PathVariable String name) {
        nodemcuService.addAjuda(name);
    }

    @PostMapping
    public NodemcuModelControle post(@RequestBody NodemcuModelControle device) {
        return nodemcuService.save(device);
    }

    @PatchMapping("/{name}")
    public NodemcuModelControle patch(@PathVariable String name, @RequestBody NodemcuModelControle nodemcuUpdates)
            throws IOException, InterruptedException {
        return nodemcuService.update(name, nodemcuUpdates);
    }

    @GetMapping("/atualizarState/{name}/{state}")
    public void atualizarCor(@PathVariable String name, @PathVariable String state) {
         nodemcuService.updateState(name, state);
    }

    @GetMapping("/atualizarTempo/{name}/{tempo}")
    public void iniciarTempo(@PathVariable String name, @PathVariable Integer tempo) {
         nodemcuService.updateLocalTC(name, tempo);
    }
}