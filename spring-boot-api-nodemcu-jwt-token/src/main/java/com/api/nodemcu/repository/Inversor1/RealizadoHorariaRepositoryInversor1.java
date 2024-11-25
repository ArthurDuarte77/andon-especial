package com.api.nodemcu.repository.Inversor1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.model.inversor1.RealizadoHorariaModelInversor1;

import java.util.List;

public interface RealizadoHorariaRepositoryInversor1 extends JpaRepository<RealizadoHorariaModelInversor1, Integer> {
    List<RealizadoHorariaModelInversor1> findAll();

    @Query(value = "SELECT SUM(horas10 + horas11 + horas12 + horas13 + horas14 + horas15 + horas16 + horas17 + horas7 + horas8 + horas9) AS total_soma FROM realizadohoraria_inversor1;", nativeQuery = true)
    Integer somarTudo();


    <RealizadoHorariaMod extends RealizadoHorariaModelInversor1> RealizadoHorariaMod save(RealizadoHorariaMod nodemcu);
}
