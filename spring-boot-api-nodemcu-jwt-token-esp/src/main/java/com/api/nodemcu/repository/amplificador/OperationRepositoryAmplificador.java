package com.api.nodemcu.repository.amplificador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador.OperationModelAmplificador;

import java.util.List;

public interface OperationRepositoryAmplificador extends JpaRepository<OperationModelAmplificador, Integer> {
    List<OperationModelAmplificador> findAll();

    OperationModelAmplificador findByName(String name);

    <OperationMod extends OperationModelAmplificador> OperationMod save(OperationMod nodemcu);

    @Modifying
    @Query(value = "update operation_amplificador set ocupado = :ocupado where id = :id", nativeQuery = true)
    void updateOcupadoByName(@Param("ocupado") Boolean ocupado, @Param("id") Integer id);

    @Modifying
    @Query(value = "update operation_amplificador set analise = :analise where id = :id", nativeQuery = true)
    void updateAnaliseById(@Param("analise") Boolean analise, @Param("id") Integer id);
}
