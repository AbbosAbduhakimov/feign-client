package com.example.currency.model;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "https://openexchangerates.org/api",name = "Currency-client")
public interface Client {


    @GetMapping("/historical/{date}.json?app_id=1b49a7dc37424a50b551a83b580d469f")
    public Currency getHistorical(@PathVariable(value = "date") String date);

    @GetMapping("/latest.json?app_id=1b49a7dc37424a50b551a83b580d469f")
    public Currency getLatest();

}

