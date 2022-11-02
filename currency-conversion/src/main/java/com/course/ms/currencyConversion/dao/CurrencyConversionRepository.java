package com.course.ms.currencyConversion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.ms.currencyConversion.models.CurrencyConverter;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConverter, Long> {

}
