package com.api.nodemcu.controllers.Inversor1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.inversor1.PausaModelInversor1;
import com.api.nodemcu.model.inversor1.QrCodeModelInversor1;
import com.api.nodemcu.repository.Inversor1.QrCodeRepositoryInversor1;

@RestController
@RequestMapping("/api/v1/qrcode_inversor1")
public class QrCodeControllerInversor1 {

    @Autowired
    private QrCodeRepositoryInversor1 qrCodeRepository;

    @GetMapping()
    List<QrCodeModelInversor1> getAll(){
        return qrCodeRepository.findAll();
    }

    @PostMapping()
    public QrCodeModelInversor1 post(@RequestBody QrCodeModelInversor1 qrcode) {
        return qrCodeRepository.save(qrcode);
    }

}
