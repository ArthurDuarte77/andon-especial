package com.api.nodemcu.repository.amplificador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.nodemcu.model.amplificador.RealizadoHorariaModelAmplificador;

import java.util.List;

public interface RealizadoHorariaRepositoryAmplificador extends JpaRepository<RealizadoHorariaModelAmplificador, Integer> {
    List<RealizadoHorariaModelAmplificador> findAll();

    @Query(value = "SELECT SUM(horas10 + horas11 + horas12 + horas13 + horas14 + horas15 + horas16 + horas17 + horas7 + horas8 + horas9) AS total_soma FROM realizadohoraria_amplificador;", nativeQuery = true)
    Integer somarTudo();


    <RealizadoHorariaMod extends RealizadoHorariaModelAmplificador> RealizadoHorariaMod save(RealizadoHorariaMod nodemcu);
}
