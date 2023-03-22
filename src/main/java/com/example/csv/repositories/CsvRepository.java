package com.example.csv.repositories;

import com.example.csv.models.Csv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsvRepository extends JpaRepository<Csv, Integer> {
    List<Csv> save(List<Csv> csvFile);

    Csv findByCode(String code);
}
