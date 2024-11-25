package com.api.nodemcu.controllers.amplificador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador.GeralNodemcuDTOAmplificador;
import com.api.nodemcu.model.amplificador.GeralNodemcuModelAmplificador;
import com.api.nodemcu.model.amplificador.OperationDTOAmplificador;
import com.api.nodemcu.model.amplificador.OperationModelAmplificador;
import com.api.nodemcu.repository.amplificador.GeralNodemcuRepositoryAmplificador;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/geral/nodemcu_amplificador")
public class GeralNodemcuControllerAmplificador {

    @Autowired
    private GeralNodemcuRepositoryAmplificador geralNodemcuRepository;

    @GetMapping("/filterByDate")
    public List<GeralNodemcuDTOAmplificador> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        List<GeralNodemcuModelAmplificador> entities = geralNodemcuRepository.findByDataBetween(startDate, endDate);
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping()
    public List<GeralNodemcuDTOAmplificador> findAll() {
        List<GeralNodemcuModelAmplificador> entities = geralNodemcuRepository.findAll();
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private GeralNodemcuDTOAmplificador convertToDTO(GeralNodemcuModelAmplificador entity) {
        GeralNodemcuDTOAmplificador dto = new GeralNodemcuDTOAmplificador();
        dto.setId(entity.getId());
        dto.setNameId(convertToOperationDTO(entity.getNameId()));
        dto.setData(entity.getData());
        dto.setCount(entity.getCount());
        dto.setFirtlastTC(entity.getFirtlastTC());
        dto.setState(entity.getState());
        dto.setCurrentTC(entity.getCurrentTC());
        dto.setAnalise(entity.getAnalise());
        dto.setTime_excess(entity.getTime_excess());
        dto.setMaintenance(entity.getMaintenance());
        dto.setSecondtlastTC(entity.getSecondtlastTC());
        dto.setAjuda(entity.getAjuda());
        dto.setThirdlastTC(entity.getThirdlastTC());
        dto.setShortestTC(entity.getShortestTC());
        dto.setQtdetcexcedido(entity.getQtdetcexcedido());
        dto.setTcmedio(entity.getTcmedio());
        return dto;
    }

    private OperationDTOAmplificador convertToOperationDTO(OperationModelAmplificador operation) {
        if (operation == null) return null;
        OperationDTOAmplificador dto = new OperationDTOAmplificador();
        dto.setId(operation.getId());
        dto.setAnalise(operation.getAnalise());
        dto.setName(operation.getName());
        dto.setOcupado(operation.getOcupado());
        dto.setPausa(operation.getPausa());
        return dto;
    }
}
