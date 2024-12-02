package com.api.nodemcu.repository.amplificador;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.amplificador.QrCodeModelAmplificador;


public interface QrCodeRepositoryAmplificador extends JpaRepository<QrCodeModelAmplificador, Integer>{
        
    List<QrCodeModelAmplificador> findAll();

    <QrCodeMod extends QrCodeModelAmplificador> QrCodeMod save(QrCodeMod pausa);
}
