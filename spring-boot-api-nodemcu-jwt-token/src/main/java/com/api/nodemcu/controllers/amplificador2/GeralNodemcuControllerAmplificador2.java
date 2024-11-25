package com.api.nodemcu.controllers.amplificador2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.amplificador2.GeralNodemcuDTOAmplificador2;
import com.api.nodemcu.model.amplificador2.GeralNodemcuModelAmplificador2;
import com.api.nodemcu.model.amplificador2.OperationDTOAmplificador2;
import com.api.nodemcu.model.amplificador2.OperationModelAmplificador2;
import com.api.nodemcu.repository.amplificador2.GeralNodemcuRepositoryAmplificador2;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/geral/nodemcu_amplificador2")
public class GeralNodemcuControllerAmplificador2 {

    @Autowired
    private GeralNodemcuRepositoryAmplificador2 geralNodemcuRepository;

    @GetMapping("/filterByDate")
    public List<GeralNodemcuDTOAmplificador2> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        List<GeralNodemcuModelAmplificador2> entities = geralNodemcuRepository.findByDataBetween(startDate, endDate);
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping()
    public List<GeralNodemcuDTOAmplificador2> findAll() {
        List<GeralNodemcuModelAmplificador2> entities = geralNodemcuRepository.findAll();
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private GeralNodemcuDTOAmplificador2 convertToDTO(GeralNodemcuModelAmplificador2 entity) {
        GeralNodemcuDTOAmplificador2 dto = new GeralNodemcuDTOAmplificador2();
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

    private OperationDTOAmplificador2 convertToOperationDTO(OperationModelAmplificador2 operation) {
        if (operation == null) return null;
        OperationDTOAmplificador2 dto = new OperationDTOAmplificador2();
        dto.setId(operation.getId());
        dto.setAnalise(operation.getAnalise());
        dto.setName(operation.getName());
        dto.setOcupado(operation.getOcupado());
        dto.setPausa(operation.getPausa());
        return dto;
    }
}
