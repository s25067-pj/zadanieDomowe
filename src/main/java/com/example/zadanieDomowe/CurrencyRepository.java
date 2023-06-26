package com.example.zadanieDomowe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Long>{
    @Override
    Currency save(Currency currency);
}

