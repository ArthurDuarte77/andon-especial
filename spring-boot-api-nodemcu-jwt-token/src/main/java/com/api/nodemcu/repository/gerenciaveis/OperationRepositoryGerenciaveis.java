package com.api.nodemcu.repository.gerenciaveis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.OperationModelControle;
import com.api.nodemcu.model.gerenciaveis.OperationModelGerenciaveis;

import java.util.List;

public interface OperationRepositoryGerenciaveis extends JpaRepository<OperationModelGerenciaveis, Integer> {
    List<OperationModelGerenciaveis> findAll();

    OperationModelGerenciaveis findByName(String name);

    <OperationMod extends OperationModelGerenciaveis> OperationMod save(OperationMod nodemcu);

    @Modifying
    @Query(value = "update operation_gerenciaveis set ocupado = :ocupado where id = :id", nativeQuery = true)
    void updateOcupadoByName(@Param("ocupado") Boolean ocupado, @Param("id") Integer id);

    @Modifying
    @Query(value = "update operation_gerenciaveis set analise = :analise where id = :id", nativeQuery = true)
    void updateAnaliseById(@Param("analise") Boolean analise, @Param("id") Integer id);
}
