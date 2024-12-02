package com.api.nodemcu.repository.amplificador2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.nodemcu.model.amplificador2.RealizadoHorariaModelAmplificador2;

import java.util.List;

public interface RealizadoHorariaRepositoryAmplificador2 extends JpaRepository<RealizadoHorariaModelAmplificador2, Integer> {
    List<RealizadoHorariaModelAmplificador2> findAll();

    @Query(value = "SELECT SUM(horas10 + horas11 + horas12 + horas13 + horas14 + horas15 + horas16 + horas17 + horas7 + horas8 + horas9) AS total_soma FROM realizadohoraria_amplificador2;", nativeQuery = true)
    Integer somarTudo();


    <RealizadoHorariaMod extends RealizadoHorariaModelAmplificador2> RealizadoHorariaMod save(RealizadoHorariaMod nodemcu);
}
