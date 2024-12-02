package com.api.nodemcu.repository.amplificador2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador2.OperationModelAmplificador2;

import java.util.List;

public interface OperationRepositoryAmplificador2 extends JpaRepository<OperationModelAmplificador2, Integer> {
    List<OperationModelAmplificador2> findAll();

    OperationModelAmplificador2 findByName(String name);

    <OperationMod extends OperationModelAmplificador2> OperationMod save(OperationMod nodemcu);

    @Modifying
    @Query(value = "update operation_amplificador2 set ocupado = :ocupado where id = :id", nativeQuery = true)
    void updateOcupadoByName(@Param("ocupado") Boolean ocupado, @Param("id") Integer id);

    @Modifying
    @Query(value = "update operation_amplificador2 set analise = :analise where id = :id", nativeQuery = true)
    void updateAnaliseById(@Param("analise") Boolean analise, @Param("id") Integer id);
}
