package com.example.csv.controllers;

import com.example.csv.models.Csv;
import com.example.csv.services.CsvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/csv")
public class CsvController {
    private CsvService csvService;

    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    @PostMapping
    public ResponseEntity<List<Csv>> createCsv (@RequestParam MultipartFile csvFile) throws IOException {
        if(csvFile.isEmpty()) {
            return new ResponseEntity<>(List.of(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(csvService.createCsv(csvFile), HttpStatus.OK);
    }

    @GetMapping("/record")
    public ResponseEntity<Csv> getCsvRecordByCode (@RequestParam String code) {
        log.info("[getCsvRecordByCode] code: " + code);
        return new ResponseEntity<>(csvService.findByCode(code), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Csv>> getAllCsvRecords () {
        log.info("[getAllCsvRecords]");
        return new ResponseEntity<List<Csv>>(csvService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll () {
        log.info("[deleteAll]");
        csvService.deleteAll();
        return new ResponseEntity<>("all records deleted", HttpStatus.OK);
    }



}
