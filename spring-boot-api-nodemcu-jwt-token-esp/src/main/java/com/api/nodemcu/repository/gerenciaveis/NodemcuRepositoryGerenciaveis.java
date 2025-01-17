package com.api.nodemcu.repository.gerenciaveis;

import jakarta.transaction.Transactional;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.controle.NodemcuModelControle;
import com.api.nodemcu.model.controle.OperationModelControle;
import com.api.nodemcu.model.gerenciaveis.NodemcuModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.OperationModelGerenciaveis;

import java.util.List;

//@EnableJpaRepositories
public interface NodemcuRepositoryGerenciaveis extends JpaRepository<NodemcuModelGerenciaveis, Integer> {

    List<NodemcuModelGerenciaveis> findAll();

    NodemcuModelGerenciaveis findByNameId(OperationModelGerenciaveis nameId);

    @Modifying
    @Query(value = "UPDATE thdados_gerenciaveis n SET n.localTC = :newLocalTC WHERE n.name_id = :nameId", nativeQuery = true)
    void updateLocalTCByNameId(@Param("newLocalTC") Integer newLocalTC, @Param("nameId") Integer nameId);
    
    @Modifying
    @Query(value = "UPDATE thdados_gerenciaveis n SET n.is_counting = :newLocalTC WHERE n.name_id = :nameId", nativeQuery = true)
    void updateIsCountingByNameId(@Param("newLocalTC") Boolean newLocalTC, @Param("nameId") Integer nameId);

    @Modifying
    @Query(value = "update thdados_gerenciaveis set state = :newState where name_id = :nameId", nativeQuery = true)
    void updateStateByNameId(@Param("newState") String newState, @Param("nameId") Integer nameId);

    <NodemcuMod extends NodemcuModelGerenciaveis> NodemcuMod save(NodemcuMod nodemcu);

}
