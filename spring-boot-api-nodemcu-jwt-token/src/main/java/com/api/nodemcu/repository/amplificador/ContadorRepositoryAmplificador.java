package com.api.nodemcu.repository.amplificador;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nodemcu.model.amplificador.ContadorAmplificador;




public interface ContadorRepositoryAmplificador extends JpaRepository<ContadorAmplificador, Long> {
}

