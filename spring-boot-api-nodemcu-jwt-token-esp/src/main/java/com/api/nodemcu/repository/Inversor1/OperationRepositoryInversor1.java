package com.api.nodemcu.repository.Inversor1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.inversor1.OperationModelInversor1;

import java.util.List;

public interface OperationRepositoryInversor1 extends JpaRepository<OperationModelInversor1, Integer> {
    List<OperationModelInversor1> findAll();

    OperationModelInversor1 findByName(String name);

    <OperationMod extends OperationModelInversor1> OperationMod save(OperationMod nodemcu);

    @Modifying
    @Query(value = "update operation_inversor1 set ocupado = :ocupado where id = :id", nativeQuery = true)
    void updateOcupadoByName(@Param("ocupado") Boolean ocupado, @Param("id") Integer id);

    @Modifying
    @Query(value = "update operation_inversor1 set analise = :analise where id = :id", nativeQuery = true)
    void updateAnaliseById(@Param("analise") Boolean analise, @Param("id") Integer id);
}
