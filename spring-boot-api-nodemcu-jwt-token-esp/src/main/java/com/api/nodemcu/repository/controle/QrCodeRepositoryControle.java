package com.api.nodemcu.repository.controle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.controle.QrCodeModelControle;

public interface QrCodeRepositoryControle extends JpaRepository<QrCodeModelControle, Integer>{
        
    List<QrCodeModelControle> findAll();

    <QrCodeMod extends QrCodeModelControle> QrCodeMod save(QrCodeMod pausa);
}
