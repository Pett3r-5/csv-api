package com.example.csv.services;

import com.example.csv.models.Csv;
import com.example.csv.repositories.CsvRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class CsvService {
    private CsvRepository csvRepository;

    CsvService(CsvRepository csvRepository){
        this.csvRepository = csvRepository;
    }

    public List<Csv> createCsv(MultipartFile multipartFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
        List<Csv> csvList = new CsvToBeanBuilder<Csv>(bufferedReader).withType(Csv.class).build().parse();
        csvRepository.saveAll(csvList);
        return csvList;
    }

    public Csv findByCode(String code) {
        return csvRepository.findByCode(code);
    }

    public List<Csv> findAll() {
        return csvRepository.findAll();
    }

    public void deleteAll() {
        csvRepository.deleteAll();
    }
}
