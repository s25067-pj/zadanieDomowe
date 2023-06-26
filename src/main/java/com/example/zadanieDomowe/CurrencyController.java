package com.example.zadanieDomowe;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyService currencyService;
    private RestTemplate restTemplate;

    @Autowired
    public CurrencyController(CurrencyService currencyService, RestTemplate restTemplate) {
        this.currencyService = currencyService;
        this.restTemplate = restTemplate;
        this.currencyService.setRestTemplate(this.restTemplate);
    }
    @Operation(summary = "Oblicz średni kurs wybranej waluty z podanej ilości dni")
    @ApiResponse(responseCode = "200", description = "Średni kurs waluty został obliczony i zapytanie zostało zapisane do bazy danych")
    @ApiResponse(responseCode = "400", description = "Invalid",content = @Content)
    @ApiResponse(responseCode = "404", description = "Currency not found",content = @Content )
    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    @GetMapping("/currency/{name}")
    public ResponseEntity<Currency> getCurrency(@PathVariable String name, @RequestParam(defaultValue = "1") int days) {

        LocalDate day = LocalDate.now();
        double average = currencyService.getMidValue(days, name);
        Currency currency = new Currency();
        currency.setTime(day);
        currency.setName(name);
        currency.setDays(days);
        currency.setAveragerate(average);
        currencyService.saveCurrency(currency);
        return ResponseEntity.ok(currency);

    }
}
