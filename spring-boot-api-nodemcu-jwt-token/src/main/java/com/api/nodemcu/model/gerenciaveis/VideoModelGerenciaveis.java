package com.api.nodemcu.model.gerenciaveis;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import jakarta.persistence.*;
import lombok.Data;

@Entity
// @Data
@Table(name = "video_gerenciaveis")
public class VideoModelGerenciaveis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "name_id")
    private OperationModelGerenciaveis nameId;

    private Date data;

    private LocalTime horario;

    @PrePersist
    protected void prePersist() {
        if (this.data == null) {
            TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
            data = new Date();
        }
        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
        if (this.horario == null) {
            this.horario = LocalTime.now(zoneId);
        }
    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public OperationModelGerenciaveis getNameId() {
        return nameId;
    }



    public void setNameId(OperationModelGerenciaveis nameId) {
        this.nameId = nameId;
    }




    public LocalTime getHorario() {
        return horario;
    }



    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
