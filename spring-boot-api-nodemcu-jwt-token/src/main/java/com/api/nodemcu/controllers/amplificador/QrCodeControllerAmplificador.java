package com.api.nodemcu.controllers.amplificador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.amplificador.QrCodeModelAmplificador;
import com.api.nodemcu.repository.amplificador.QrCodeRepositoryAmplificador;


@RestController
@RequestMapping("/api/v1/qrcode_amplificador")
public class QrCodeControllerAmplificador {

    @Autowired
    private QrCodeRepositoryAmplificador qrCodeRepository;

    @GetMapping()
    List<QrCodeModelAmplificador> getAll(){
        return qrCodeRepository.findAll();
    }

    @PostMapping()
    public QrCodeModelAmplificador post(@RequestBody QrCodeModelAmplificador qrcode) {
        return qrCodeRepository.save(qrcode);
    }

}
