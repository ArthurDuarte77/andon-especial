package com.api.nodemcu.controllers.Inversor2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.Inversor2.GeralNodemcuDTOInversor2;
import com.api.nodemcu.model.Inversor2.GeralNodemcuModelInversor2;
import com.api.nodemcu.model.Inversor2.OperationDTOInversor2;
import com.api.nodemcu.model.Inversor2.OperationModelInversor2;
import com.api.nodemcu.model.inversor1.GeralNodemcuDTOInversor1;
import com.api.nodemcu.model.inversor1.GeralNodemcuModelInversor1;
import com.api.nodemcu.model.inversor1.OperationDTOInversor1;
import com.api.nodemcu.model.inversor1.OperationModelInversor1;
import com.api.nodemcu.repository.Inversor1.GeralNodemcuRepositoryInversor1;
import com.api.nodemcu.repository.Inversor2.GeralNodemcuRepositoryInversor2;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/geral/nodemcu_inversor2")
public class GeralNodemcuControllerInversor2 {

    @Autowired
    private GeralNodemcuRepositoryInversor2 geralNodemcuRepository;

    @GetMapping("/filterByDate")
    public List<GeralNodemcuDTOInversor2> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        List<GeralNodemcuModelInversor2> entities = geralNodemcuRepository.findByDataBetween(startDate, endDate);
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping()
    public List<GeralNodemcuDTOInversor2> findAll() {
        List<GeralNodemcuModelInversor2> entities = geralNodemcuRepository.findAll();
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private GeralNodemcuDTOInversor2 convertToDTO(GeralNodemcuModelInversor2 entity) {
        GeralNodemcuDTOInversor2 dto = new GeralNodemcuDTOInversor2();
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

    private OperationDTOInversor2 convertToOperationDTO(OperationModelInversor2 operation) {
        if (operation == null) return null;
        OperationDTOInversor2 dto = new OperationDTOInversor2();
        dto.setId(operation.getId());
        dto.setAnalise(operation.getAnalise());
        dto.setName(operation.getName());
        dto.setOcupado(operation.getOcupado());
        dto.setPausa(operation.getPausa());
        return dto;
    }
}
