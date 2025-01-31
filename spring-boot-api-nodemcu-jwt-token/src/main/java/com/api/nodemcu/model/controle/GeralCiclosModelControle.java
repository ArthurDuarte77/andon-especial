package com.api.nodemcu.model.controle;

import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

@Entity
// @Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "geral_ciclo_controle")
public class GeralCiclosModelControle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_id")
    private OperationModelControle nameId;

    private Integer count;

    private Integer time;

    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OperationModelControle getNameId() {
        return nameId;
    }

    public void setNameId(OperationModelControle nameId) {
        this.nameId = nameId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
}
