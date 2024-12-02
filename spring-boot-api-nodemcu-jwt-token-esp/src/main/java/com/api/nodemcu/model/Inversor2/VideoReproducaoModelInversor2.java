package com.api.nodemcu.model.Inversor2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "reproducao_inversor2")
public class VideoReproducaoModelInversor2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "name_id")
    private OperationModelInversor2 nameId;

    private String codigo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OperationModelInversor2 getNameId() {
        return nameId;
    }

    public void setNameId(OperationModelInversor2 nameId) {
        this.nameId = nameId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    

}
