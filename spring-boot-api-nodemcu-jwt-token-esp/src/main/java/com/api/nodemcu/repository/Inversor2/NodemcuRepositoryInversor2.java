package com.api.nodemcu.repository.Inversor2;

import jakarta.transaction.Transactional;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.api.nodemcu.model.Inversor2.NodemcuModelInversor2;
import com.api.nodemcu.model.Inversor2.OperationModelInversor2;
import com.api.nodemcu.model.inversor1.NodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;

import java.util.List;

//@EnableJpaRepositories
public interface NodemcuRepositoryInversor2 extends JpaRepository<NodemcuModelInversor2, Integer> {

    List<NodemcuModelInversor2> findAll();

    NodemcuModelInversor2 findByNameId(OperationModelInversor2 nameId);

    @Modifying
    @Query(value = "UPDATE thdados_inversor2 n SET n.localTC = :newLocalTC WHERE n.name_id = :nameId", nativeQuery = true)
    void updateLocalTCByNameId(@Param("newLocalTC") Integer newLocalTC, @Param("nameId") Integer nameId);
    
    @Modifying
    @Query(value = "UPDATE thdados_inversor2 n SET n.is_counting = :newLocalTC WHERE n.name_id = :nameId", nativeQuery = true)
    void updateIsCountingByNameId(@Param("newLocalTC") Boolean newLocalTC, @Param("nameId") Integer nameId);

    @Modifying
    @Query(value = "update thdados_inversor2 set state = :newState where name_id = :nameId", nativeQuery = true)
    void updateStateByNameId(@Param("newState") String newState, @Param("nameId") Integer nameId);

    <NodemcuMod extends NodemcuModelInversor2> NodemcuMod save(NodemcuMod nodemcu);

}
