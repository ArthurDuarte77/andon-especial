package com.api.nodemcu.repository.controle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.OperationModelControle;
import com.api.nodemcu.model.controle.RealizadoHorariaTabletModelControle;

public interface RealizadoHorariaTabletRepositoryControle extends JpaRepository<RealizadoHorariaTabletModelControle, Integer> {
    List<RealizadoHorariaTabletModelControle> findAll();

    @Query(value = "SELECT SUM(horas10 + horas11 + horas12 + horas13 + horas14 + horas15 + horas16 + horas17 + horas7 + horas8 + horas9) AS total_soma FROM realizadohoraria_tablet_controle WHERE id = :id", nativeQuery = true)
    Integer somarTudo(@Param("id") Integer id);

    RealizadoHorariaTabletModelControle findByNameId(OperationModelControle name);

    <RealizadoHorariaTabletMod extends RealizadoHorariaTabletModelControle> RealizadoHorariaTabletMod save(RealizadoHorariaTabletMod nodemcu);
}
