package com.api.nodemcu.controllers.Inversor1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.inversor1.GeralNodemcuDTOInversor1;
import com.api.nodemcu.model.inversor1.GeralNodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.OperationDTOInversor1;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.repository.Inversor1.GeralNodemcuRepositoryInversor1;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/geral/nodemcu_inversor1")
public class GeralNodemcuControllerInversor1 {

    @Autowired
    private GeralNodemcuRepositoryInversor1 geralNodemcuRepository;

    @GetMapping("/filterByDate")
    public List<GeralNodemcuDTOInversor1> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        List<GeralNodemcuModelInversor1> entities = geralNodemcuRepository.findByDataBetween(startDate, endDate);
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping()
    public List<GeralNodemcuDTOInversor1> findAll() {
        List<GeralNodemcuModelInversor1> entities = geralNodemcuRepository.findAll();
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private GeralNodemcuDTOInversor1 convertToDTO(GeralNodemcuModelInversor1 entity) {
        GeralNodemcuDTOInversor1 dto = new GeralNodemcuDTOInversor1();
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

    private OperationDTOInversor1 convertToOperationDTO(OperationModelInversor1 operation) {
        if (operation == null) return null;
        OperationDTOInversor1 dto = new OperationDTOInversor1();
        dto.setId(operation.getId());
        dto.setAnalise(operation.getAnalise());
        dto.setName(operation.getName());
        dto.setOcupado(operation.getOcupado());
        dto.setPausa(operation.getPausa());
        return dto;
    }
}
