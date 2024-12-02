package com.api.nodemcu.repository.Inversor2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.Inversor2.OperationModelInversor2;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;

import java.util.List;

public interface OperationRepositoryInversor2 extends JpaRepository<OperationModelInversor2, Integer> {
    List<OperationModelInversor2> findAll();

    OperationModelInversor2 findByName(String name);

    <OperationMod extends OperationModelInversor2> OperationMod save(OperationMod nodemcu);

    @Modifying
    @Query(value = "update operation_inversor2 set ocupado = :ocupado where id = :id", nativeQuery = true)
    void updateOcupadoByName(@Param("ocupado") Boolean ocupado, @Param("id") Integer id);

    @Modifying
    @Query(value = "update operation_inversor2 set analise = :analise where id = :id", nativeQuery = true)
    void updateAnaliseById(@Param("analise") Boolean analise, @Param("id") Integer id);
}
