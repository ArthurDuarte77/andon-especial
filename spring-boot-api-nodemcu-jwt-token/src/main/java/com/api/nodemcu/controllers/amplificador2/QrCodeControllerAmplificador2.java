package com.api.nodemcu.controllers.amplificador2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.amplificador2.QrCodeModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.QrCodeRepositoryAmplificador2;



@RestController
@RequestMapping("/api/v1/qrcode_amplificador2")
public class QrCodeControllerAmplificador2 {

    @Autowired
    private QrCodeRepositoryAmplificador2 qrCodeRepository;

    @GetMapping()
    List<QrCodeModelAmplificador2> getAll(){
        return qrCodeRepository.findAll();
    }

    @PostMapping()
    public QrCodeModelAmplificador2 post(@RequestBody QrCodeModelAmplificador2 qrcode) {
        return qrCodeRepository.save(qrcode);
    }

}
