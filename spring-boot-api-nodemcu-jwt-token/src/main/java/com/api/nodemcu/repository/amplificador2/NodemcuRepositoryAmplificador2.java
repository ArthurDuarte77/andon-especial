package com.api.nodemcu.repository.amplificador2;

import jakarta.transaction.Transactional;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.amplificador2.NodemcuModelAmplificador2;
import com.api.nodemcu.model.amplificador2.OperationModelAmplificador2;

import java.util.List;

//@EnableJpaRepositories
public interface NodemcuRepositoryAmplificador2 extends JpaRepository<NodemcuModelAmplificador2, Integer> {

    List<NodemcuModelAmplificador2> findAll();

    NodemcuModelAmplificador2 findByNameId(OperationModelAmplificador2 nameId);

    @Modifying
    @Query(value = "UPDATE thdados_amplificador2 n SET n.localTC = :newLocalTC WHERE n.name_id = :nameId", nativeQuery = true)
    void updateLocalTCByNameId(@Param("newLocalTC") Integer newLocalTC, @Param("nameId") Integer nameId);
    
    @Modifying
    @Query(value = "UPDATE thdados_amplificador2 n SET n.is_counting = :newLocalTC WHERE n.name_id = :nameId", nativeQuery = true)
    void updateIsCountingByNameId(@Param("newLocalTC") Boolean newLocalTC, @Param("nameId") Integer nameId);

    @Modifying
    @Query(value = "update thdados_amplificador2 set state = :newState where name_id = :nameId", nativeQuery = true)
    void updateStateByNameId(@Param("newState") String newState, @Param("nameId") Integer nameId);

    <NodemcuMod extends NodemcuModelAmplificador2> NodemcuMod save(NodemcuMod nodemcu);

}
