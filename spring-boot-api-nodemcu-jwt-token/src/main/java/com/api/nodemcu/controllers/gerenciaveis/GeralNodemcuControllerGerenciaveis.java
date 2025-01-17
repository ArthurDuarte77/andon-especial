package com.api.nodemcu.controllers.gerenciaveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.gerenciaveis.GeralNodemcuDTOGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.GeralNodemcuModelGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.OperationDTOGerenciaveis;
import com.api.nodemcu.model.gerenciaveis.OperationModelGerenciaveis;
import com.api.nodemcu.repository.gerenciaveis.GeralNodemcuRepositoryGerenciaveis;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/geral/nodemcu_gerenciaveis")
public class GeralNodemcuControllerGerenciaveis {

    @Autowired
    private GeralNodemcuRepositoryGerenciaveis geralNodemcuRepository;

    @GetMapping("/filterByDate")
    public List<GeralNodemcuDTOGerenciaveis> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        List<GeralNodemcuModelGerenciaveis> entities = geralNodemcuRepository.findByDataBetween(startDate, endDate);
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping()
    public List<GeralNodemcuDTOGerenciaveis> findAll() {
        List<GeralNodemcuModelGerenciaveis> entities = geralNodemcuRepository.findAll();
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private GeralNodemcuDTOGerenciaveis convertToDTO(GeralNodemcuModelGerenciaveis entity) {
        GeralNodemcuDTOGerenciaveis dto = new GeralNodemcuDTOGerenciaveis();
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

    private OperationDTOGerenciaveis convertToOperationDTO(OperationModelGerenciaveis operation) {
        if (operation == null) return null;
        OperationDTOGerenciaveis dto = new OperationDTOGerenciaveis();
        dto.setId(operation.getId());
        dto.setAnalise(operation.getAnalise());
        dto.setName(operation.getName());
        dto.setOcupado(operation.getOcupado());
        dto.setPausa(operation.getPausa());
        return dto;
    }
}
