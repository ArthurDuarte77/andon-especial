package com.api.nodemcu.repository.Inversor2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.Inversor2.OperationModelInversor2;
import com.api.nodemcu.model.Inversor2.RealizadoHorariaTabletModelInversor2;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.model.inversor1.RealizadoHorariaTabletModelInversor1;

public interface RealizadoHorariaTabletRepositoryInversor2 extends JpaRepository<RealizadoHorariaTabletModelInversor2, Integer> {
    List<RealizadoHorariaTabletModelInversor2> findAll();

    @Query(value = "SELECT SUM(horas10 + horas11 + horas12 + horas13 + horas14 + horas15 + horas16 + horas17 + horas7 + horas8 + horas9) AS total_soma FROM realizadohoraria_tablet_inversor2 WHERE id = :id", nativeQuery = true)
    Integer somarTudo(@Param("id") Integer id);

    RealizadoHorariaTabletModelInversor2 findByNameId(OperationModelInversor2 name);

    <RealizadoHorariaTabletMod extends RealizadoHorariaTabletModelInversor2> RealizadoHorariaTabletMod save(RealizadoHorariaTabletMod nodemcu);
}
