package com.api.nodemcu.repository.Inversor2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.nodemcu.model.Inversor2.RealizadoHorariaModelInversor2;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.model.inversor1.RealizadoHorariaModelInversor1;

import java.util.List;

public interface RealizadoHorariaRepositoryInversor2 extends JpaRepository<RealizadoHorariaModelInversor2, Integer> {
    List<RealizadoHorariaModelInversor2> findAll();

    @Query(value = "SELECT SUM(horas10 + horas11 + horas12 + horas13 + horas14 + horas15 + horas16 + horas17 + horas7 + horas8 + horas9) AS total_soma FROM realizadohoraria_inversor2;", nativeQuery = true)
    Integer somarTudo();


    <RealizadoHorariaMod extends RealizadoHorariaModelInversor2> RealizadoHorariaMod save(RealizadoHorariaMod nodemcu);
}
