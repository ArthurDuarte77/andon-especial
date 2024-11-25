package com.api.nodemcu.repository.amplificador2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.amplificador2.QrCodeModelAmplificador2;


public interface QrCodeRepositoryAmplificador2 extends JpaRepository<QrCodeModelAmplificador2, Integer>{
        
    List<QrCodeModelAmplificador2> findAll();

    <QrCodeMod extends QrCodeModelAmplificador2> QrCodeMod save(QrCodeMod pausa);
}
