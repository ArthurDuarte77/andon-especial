package com.api.nodemcu.controllers.Inversor2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.nodemcu.model.Inversor2.QrCodeModelInversor2;
import com.api.nodemcu.model.inversor1.PausaModelInversor1;
import com.api.nodemcu.model.inversor1.QrCodeModelInversor1;
import com.api.nodemcu.repository.Inversor1.QrCodeRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.QrCodeRepositoryInversor2;

@RestController
@RequestMapping("/api/v1/qrcode_inversor2")
public class QrCodeControllerInversor2 {

    @Autowired
    private QrCodeRepositoryInversor2 qrCodeRepository;

    @GetMapping()
    List<QrCodeModelInversor2> getAll(){
        return qrCodeRepository.findAll();
    }

    @PostMapping()
    public QrCodeModelInversor2 post(@RequestBody QrCodeModelInversor2 qrcode) {
        return qrCodeRepository.save(qrcode);
    }

}
