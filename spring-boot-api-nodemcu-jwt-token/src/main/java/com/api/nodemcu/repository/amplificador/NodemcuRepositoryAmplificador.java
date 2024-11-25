package com.api.nodemcu.repository.amplificador;

import jakarta.transaction.Transactional;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador.NodemcuModelAmplificador;
import com.api.nodemcu.model.amplificador.OperationModelAmplificador;

import java.util.List;

//@EnableJpaRepositories
public interface NodemcuRepositoryAmplificador extends JpaRepository<NodemcuModelAmplificador, Integer> {

    List<NodemcuModelAmplificador> findAll();

    NodemcuModelAmplificador findByNameId(OperationModelAmplificador nameId);

    @Modifying
    @Query(value = "UPDATE thdados_amplificador n SET n.localTC = :newLocalTC WHERE n.name_id = :nameId", nativeQuery = true)
    void updateLocalTCByNameId(@Param("newLocalTC") Integer newLocalTC, @Param("nameId") Integer nameId);
    
    @Modifying
    @Query(value = "UPDATE thdados_amplificador n SET n.is_counting = :newLocalTC WHERE n.name_id = :nameId", nativeQuery = true)
    void updateIsCountingByNameId(@Param("newLocalTC") Boolean newLocalTC, @Param("nameId") Integer nameId);

    @Modifying
    @Query(value = "update thdados_amplificador set state = :newState where name_id = :nameId", nativeQuery = true)
    void updateStateByNameId(@Param("newState") String newState, @Param("nameId") Integer nameId);

    <NodemcuMod extends NodemcuModelAmplificador> NodemcuMod save(NodemcuMod nodemcu);

}
