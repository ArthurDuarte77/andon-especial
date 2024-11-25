package com.api.nodemcu.repository.Inversor2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.Inversor2.QrCodeModelInversor2;
import com.api.nodemcu.model.inversor1.PausaModelInversor1;
import com.api.nodemcu.model.inversor1.QrCodeModelInversor1;

public interface QrCodeRepositoryInversor2 extends JpaRepository<QrCodeModelInversor2, Integer>{
        
    List<QrCodeModelInversor2> findAll();

    <QrCodeMod extends QrCodeModelInversor2> QrCodeMod save(QrCodeMod pausa);
}
