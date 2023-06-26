package com.example.zadanieDomowe;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Currency {

    @Id
    @GeneratedValue
    @Schema(description = "Id waluty", type = "long")
    private Long id;

    @Schema(description = "Kod waluty", type = "String")
    private String name;

    @Schema(description = "Średni kurs waluty z wybranych ilości dni",type = "double")
    private double averagerate;

    @Schema(description = "Ilość dni, z których został obliczony średni kurs wybranej waluty", type="int")
    private int days;

    @Schema(description = "Czas, w którym zostało wysłane zapytanie", type="LocalDateTime")
    private LocalDateTime time;

    public Currency(Long id, String name, double averagerate, int days, LocalDateTime time) {
        this.id = id;
        this.name = name;
        this.averagerate = averagerate;
        this.days = days;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAveragerate() {
        return averagerate;
    }

    public void setAveragerate(double averagerate) {
        this.averagerate = averagerate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
