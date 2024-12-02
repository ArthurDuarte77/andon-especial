package com.api.nodemcu.model.amplificador2;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Entity
// @Data
@Table(name="thdados_amplificador2")
public class NodemcuModelAmplificador2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "name_id")
    private OperationModelAmplificador2 nameId;

    @OneToOne
    @JoinColumn(name = "contador")
    private ContadorAmplificador2 contador;


    private Integer count;

    private Integer firtlastTC;

    private String state;

    private Integer currentTC;

    private Integer analise;

    private Integer time_excess;

    private Integer maintenance;

    private Integer secondtlastTC;

    private Integer ajuda;

    private Integer thirdlastTC;

    private Integer shortestTC;

    private Integer qtdetcexcedido;

    private Integer tcmedio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OperationModelAmplificador2 getNameId() {
        return nameId;
    }

    public void setNameId(OperationModelAmplificador2 nameId) {
        this.nameId = nameId;
    }

    public ContadorAmplificador2 getContador() {
        return contador;
    }

    public void setContador(ContadorAmplificador2 contador) {
        this.contador = contador;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getFirtlastTC() {
        return firtlastTC;
    }

    public void setFirtlastTC(Integer firtlastTC) {
        this.firtlastTC = firtlastTC;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCurrentTC() {
        return currentTC;
    }

    public void setCurrentTC(Integer currentTC) {
        this.currentTC = currentTC;
    }

    public Integer getAnalise() {
        return analise;
    }

    public void setAnalise(Integer analise) {
        this.analise = analise;
    }

    public Integer getTime_excess() {
        return time_excess;
    }

    public void setTime_excess(Integer time_excess) {
        this.time_excess = time_excess;
    }

    public Integer getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Integer maintenance) {
        this.maintenance = maintenance;
    }

    public Integer getSecondtlastTC() {
        return secondtlastTC;
    }

    public void setSecondtlastTC(Integer secondtlastTC) {
        this.secondtlastTC = secondtlastTC;
    }

    public Integer getAjuda() {
        return ajuda;
    }

    public void setAjuda(Integer ajuda) {
        this.ajuda = ajuda;
    }

    public Integer getThirdlastTC() {
        return thirdlastTC;
    }

    public void setThirdlastTC(Integer thirdlastTC) {
        this.thirdlastTC = thirdlastTC;
    }

    public Integer getShortestTC() {
        return shortestTC;
    }

    public void setShortestTC(Integer shortestTC) {
        this.shortestTC = shortestTC;
    }

    public Integer getQtdetcexcedido() {
        return qtdetcexcedido;
    }

    public void setQtdetcexcedido(Integer qtdetcexcedido) {
        this.qtdetcexcedido = qtdetcexcedido;
    }

    public Integer getTcmedio() {
        return tcmedio;
    }

    public void setTcmedio(Integer tcmedio) {
        this.tcmedio = tcmedio;
    }

        
}

