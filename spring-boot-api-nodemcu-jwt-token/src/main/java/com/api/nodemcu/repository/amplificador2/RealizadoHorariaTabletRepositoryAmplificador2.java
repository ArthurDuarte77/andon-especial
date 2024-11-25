package com.api.nodemcu.repository.amplificador2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador2.OperationModelAmplificador2;
import com.api.nodemcu.model.amplificador2.RealizadoHorariaTabletModelAmplificador2;

public interface RealizadoHorariaTabletRepositoryAmplificador2 extends JpaRepository<RealizadoHorariaTabletModelAmplificador2, Integer> {
    List<RealizadoHorariaTabletModelAmplificador2> findAll();

    @Query(value = "SELECT SUM(horas10 + horas11 + horas12 + horas13 + horas14 + horas15 + horas16 + horas17 + horas7 + horas8 + horas9) AS total_soma FROM realizadohoraria_tablet_amplificador2 WHERE id = :id", nativeQuery = true)
    Integer somarTudo(@Param("id") Integer id);

    RealizadoHorariaTabletModelAmplificador2 findByNameId(OperationModelAmplificador2 name);

    <RealizadoHorariaTabletMod extends RealizadoHorariaTabletModelAmplificador2> RealizadoHorariaTabletMod save(RealizadoHorariaTabletMod nodemcu);
}
        