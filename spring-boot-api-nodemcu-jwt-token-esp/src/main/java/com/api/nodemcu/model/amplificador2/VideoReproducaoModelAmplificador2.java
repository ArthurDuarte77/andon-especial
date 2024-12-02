package com.api.nodemcu.model.amplificador2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "reproducao_amplificador2")
public class VideoReproducaoModelAmplificador2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "name_id")
    private OperationModelAmplificador2 nameId;

    private String codigo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OperationModelAmplificador2 getNameId() {
        return nameId;
    }

    public void setNameId(OperationModelAmplificador2 nameId) {
        this.nameId = nameId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    

}
