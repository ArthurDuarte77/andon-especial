package com.api.nodemcu.controllers.controle;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.nodemcu.model.controle.VideoModelControle;
import com.api.nodemcu.repository.controle.VideoRepositoryControle;

@RestController
@RequestMapping("/api/v1/geral/video_controle")
public class VideoControllerControle {
    @Autowired
    private VideoRepositoryControle videoRepository;

    @GetMapping()
    public List<VideoModelControle> getAll(){
        return videoRepository.findAll();
    }

    @PostMapping()
    VideoModelControle post(@RequestBody VideoModelControle video){
        return videoRepository.save(video);
    }

    @GetMapping("/filterByDate")
    public List<VideoModelControle> filterByDate(@RequestParam("startDate") String startDate,
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
            List<VideoModelControle> allRecords = videoRepository.findAll();

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
}