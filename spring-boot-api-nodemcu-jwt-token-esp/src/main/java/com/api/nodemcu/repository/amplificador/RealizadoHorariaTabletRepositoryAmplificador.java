package com.api.nodemcu.repository.amplificador;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador.OperationModelAmplificador;
import com.api.nodemcu.model.amplificador.RealizadoHorariaTabletModelAmplificador;

public interface RealizadoHorariaTabletRepositoryAmplificador extends JpaRepository<RealizadoHorariaTabletModelAmplificador, Integer> {
    List<RealizadoHorariaTabletModelAmplificador> findAll();

    @Query(value = "SELECT SUM(horas10 + horas11 + horas12 + horas13 + horas14 + horas15 + horas16 + horas17 + horas7 + horas8 + horas9) AS total_soma FROM realizadohoraria_tablet_amplificador WHERE id = :id", nativeQuery = true)
    Integer somarTudo(@Param("id") Integer id);

    RealizadoHorariaTabletModelAmplificador findByNameId(OperationModelAmplificador name);

    <RealizadoHorariaTabletMod extends RealizadoHorariaTabletModelAmplificador> RealizadoHorariaTabletMod save(RealizadoHorariaTabletMod nodemcu);
}
        