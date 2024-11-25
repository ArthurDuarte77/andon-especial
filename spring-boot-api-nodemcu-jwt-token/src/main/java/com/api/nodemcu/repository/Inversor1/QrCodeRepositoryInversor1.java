package com.api.nodemcu.repository.Inversor1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.inversor1.PausaModelInversor1;
import com.api.nodemcu.model.inversor1.QrCodeModelInversor1;

public interface QrCodeRepositoryInversor1 extends JpaRepository<QrCodeModelInversor1, Integer>{
        
    List<QrCodeModelInversor1> findAll();

    <QrCodeMod extends QrCodeModelInversor1> QrCodeMod save(QrCodeMod pausa);
}
