package com.example.currency.model.currency;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class Currency {
    private Map<String,Double> rates;
}
