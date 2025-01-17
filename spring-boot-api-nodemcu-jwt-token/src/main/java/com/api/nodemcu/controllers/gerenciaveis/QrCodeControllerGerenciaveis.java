package com.api.nodemcu.controllers.gerenciaveis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.gerenciaveis.QrCodeModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.QrCodeRepositoryGerenciaveis;


@RestController
@RequestMapping("/api/v1/qrcode_gerenciaveis")
public class QrCodeControllerGerenciaveis {

    @Autowired
    private QrCodeRepositoryGerenciaveis qrCodeRepository;

    @GetMapping()
    List<QrCodeModelGerenciaveis> getAll(){
        return qrCodeRepository.findAll();
    }

    @PostMapping()
    public QrCodeModelGerenciaveis post(@RequestBody QrCodeModelGerenciaveis qrcode) {
        return qrCodeRepository.save(qrcode);
    }

}
