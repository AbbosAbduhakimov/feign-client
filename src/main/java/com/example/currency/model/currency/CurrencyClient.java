package com.example.currency.model.currency;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url = "https://openexchangerates.org/api", name = "currency-client")
public interface CurrencyClient {


    @GetMapping("/historical/{date}.json")
    Currency getHistorical(@PathVariable(value = "date") String date, @RequestParam("symbols") String symbols);

    @GetMapping("/latest.json")
    Currency getLatest(@RequestParam("symbols") String symbols);

}

