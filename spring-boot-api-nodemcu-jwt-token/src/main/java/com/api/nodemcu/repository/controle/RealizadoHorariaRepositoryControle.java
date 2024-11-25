package com.api.nodemcu.repository.controle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.nodemcu.model.controle.RealizadoHorariaModelControle;

import java.util.List;

public interface RealizadoHorariaRepositoryControle extends JpaRepository<RealizadoHorariaModelControle, Integer> {
    List<RealizadoHorariaModelControle> findAll();

    @Query(value = "SELECT SUM(horas10 + horas11 + horas12 + horas13 + horas14 + horas15 + horas16 + horas17 + horas7 + horas8 + horas9) AS total_soma FROM realizadohoraria_controle;", nativeQuery = true)
    Integer somarTudo();


    <RealizadoHorariaMod extends RealizadoHorariaModelControle> RealizadoHorariaMod save(RealizadoHorariaMod nodemcu);
}
