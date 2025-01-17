package com.api.nodemcu.repository.gerenciaveis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.OperationModelControle;
import com.api.nodemcu.model.controle.RealizadoHorariaTabletModelControle;
import com.api.nodemcu.model.gerenciaveis.OperationModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.RealizadoHorariaTabletModelGerenciaveis;

public interface RealizadoHorariaTabletRepositoryGerenciaveis extends JpaRepository<RealizadoHorariaTabletModelGerenciaveis, Integer> {
    List<RealizadoHorariaTabletModelGerenciaveis> findAll();

    @Query(value = "SELECT SUM(horas10 + horas11 + horas12 + horas13 + horas14 + horas15 + horas16 + horas17 + horas7 + horas8 + horas9) AS total_soma FROM realizadohoraria_tablet_gerenciaveis WHERE id = :id", nativeQuery = true)
    Integer somarTudo(@Param("id") Integer id);

    RealizadoHorariaTabletModelGerenciaveis findByNameId(OperationModelGerenciaveis name);

    <RealizadoHorariaTabletMod extends RealizadoHorariaTabletModelGerenciaveis> RealizadoHorariaTabletMod save(RealizadoHorariaTabletMod nodemcu);
}
