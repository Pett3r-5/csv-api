package com.example.csv.models;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity(name="CSV")
@Table(name="CSV")
public class Csv implements Serializable {
    @CsvBindByName
    private String source;

    @CsvBindByName
    private String codeListCode;

    @CsvBindByName
    @Id
    private String code;

    @CsvBindByName
    private String displayValue;

    @CsvBindByName
    private String longDescription;

    @CsvBindByName
    private String fromDate;

    @CsvBindByName
    private String toDate;

    @CsvBindByName
    private String sortingPriority;
}
