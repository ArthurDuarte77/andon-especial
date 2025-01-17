package com.api.nodemcu.repository.gerenciaveis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.controle.QrCodeModelControle;
import com.api.nodemcu.model.gerenciaveis.QrCodeModelGerenciaveis;

public interface QrCodeRepositoryGerenciaveis extends JpaRepository<QrCodeModelGerenciaveis, Integer>{
        
    List<QrCodeModelGerenciaveis> findAll();

    <QrCodeMod extends QrCodeModelGerenciaveis> QrCodeMod save(QrCodeMod pausa);
}
