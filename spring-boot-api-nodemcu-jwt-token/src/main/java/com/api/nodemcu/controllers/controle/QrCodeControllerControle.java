package com.api.nodemcu.controllers.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.controle.QrCodeModelControle;
import com.api.nodemcu.repository.controle.QrCodeRepositoryControle;

@RestController
@RequestMapping("/api/v1/qrcode_controle")
public class QrCodeControllerControle {

    @Autowired
    private QrCodeRepositoryControle qrCodeRepository;

    @GetMapping()
    List<QrCodeModelControle> getAll(){
        return qrCodeRepository.findAll();
    }

    @PostMapping()
    public QrCodeModelControle post(@RequestBody QrCodeModelControle qrcode) {
        return qrCodeRepository.save(qrcode);
    }

}
