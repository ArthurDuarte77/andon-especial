package com.api.nodemcu.repository.controle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.OperationModelControle;

import java.util.List;

public interface OperationRepositoryControle extends JpaRepository<OperationModelControle, Integer> {
    List<OperationModelControle> findAll();

    OperationModelControle findByName(String name);

    <OperationMod extends OperationModelControle> OperationMod save(OperationMod nodemcu);

    @Modifying
    @Query(value = "update operation_controle set ocupado = :ocupado where id = :id", nativeQuery = true)
    void updateOcupadoByName(@Param("ocupado") Boolean ocupado, @Param("id") Integer id);

    @Modifying
    @Query(value = "update operation_controle set analise = :analise where id = :id", nativeQuery = true)
    void updateAnaliseById(@Param("analise") Boolean analise, @Param("id") Integer id);
}
