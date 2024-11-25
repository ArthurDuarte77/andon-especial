package com.api.nodemcu.model.inversor1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "reproducao_inversor1")
public class VideoReproducaoModelInversor1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "name_id")
    private OperationModelInversor1 nameId;

    private String codigo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OperationModelInversor1 getNameId() {
        return nameId;
    }

    public void setNameId(OperationModelInversor1 nameId) {
        this.nameId = nameId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    

}
