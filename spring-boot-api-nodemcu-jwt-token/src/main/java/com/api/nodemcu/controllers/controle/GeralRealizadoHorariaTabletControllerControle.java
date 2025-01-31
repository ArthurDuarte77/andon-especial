package com.api.nodemcu.controllers.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.api.nodemcu.model.controle.GeralRealizadoHorariaTabletModelControle;
import com.api.nodemcu.repository.controle.GeralRealizadoHorariaTabletRepositoryControle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/geral/realizadoHorariaTablet_controle")
public class GeralRealizadoHorariaTabletControllerControle {

    @Autowired
    private GeralRealizadoHorariaTabletRepositoryControle geralRealizadoHorariaTabletRepository;

    @GetMapping("/filterByDate")
    public List<GeralRealizadoHorariaTabletModelControle> filterByDate(@RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) {
        try {
            // Construindo um DateTimeFormatter flexível que adiciona os zeros ausentes ao
            // mês e ao dia
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendPattern("yyyy[-MM[-dd]]")
                    .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                    .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                    .toFormatter();

            LocalDate start = LocalDate.parse(startDate, formatter);
            LocalDate end = LocalDate.parse(endDate, formatter);

            // Obtendo todos os registros e filtrando pelas datas
            List<GeralRealizadoHorariaTabletModelControle> allRecords = geralRealizadoHorariaTabletRepository.findAll();

            return allRecords.stream()
                    .filter(record -> {
                        LocalDate recordDate = record.getData().toInstant().atZone(ZoneId.systemDefault())
                                .toLocalDate();
                        return (recordDate.isEqual(start) || recordDate.isAfter(start)) &&
                                (recordDate.isEqual(end) || recordDate.isBefore(end));
                    })
                    .collect(Collectors.toList());
        } catch (DateTimeParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Formato de data inválido. Use o formato yyyy-MM-dd.");
        }
    }

    private LocalDateTime convertToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    @GetMapping()
    public List<GeralRealizadoHorariaTabletModelControle> findAll() {
        return geralRealizadoHorariaTabletRepository.findAll();
    }
}
