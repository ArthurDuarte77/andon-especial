package com.api.nodemcu.controllers.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.nodemcu.model.controle.GeralNodemcuDTOControle;
import com.api.nodemcu.model.controle.GeralNodemcuModelControle;
import com.api.nodemcu.model.controle.OperationDTOControle;
import com.api.nodemcu.model.controle.OperationModelControle;
import com.api.nodemcu.repository.controle.GeralNodemcuRepositoryControle;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/geral/nodemcu_controle")
public class GeralNodemcuControllerControle {

    @Autowired
    private GeralNodemcuRepositoryControle geralNodemcuRepository;

    @GetMapping("/filterByDate")
    public List<GeralNodemcuDTOControle> filterByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        List<GeralNodemcuModelControle> entities = geralNodemcuRepository.findByDataBetween(startDate, endDate);
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping()
    public List<GeralNodemcuDTOControle> findAll() {
        List<GeralNodemcuModelControle> entities = geralNodemcuRepository.findAll();
        return entities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private GeralNodemcuDTOControle convertToDTO(GeralNodemcuModelControle entity) {
        GeralNodemcuDTOControle dto = new GeralNodemcuDTOControle();
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

    private OperationDTOControle convertToOperationDTO(OperationModelControle operation) {
        if (operation == null) return null;
        OperationDTOControle dto = new OperationDTOControle();
        dto.setId(operation.getId());
        dto.setAnalise(operation.getAnalise());
        dto.setName(operation.getName());
        dto.setOcupado(operation.getOcupado());
        dto.setPausa(operation.getPausa());
        return dto;
    }
}
