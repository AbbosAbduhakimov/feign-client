package com.example.currency.controller;


import com.example.currency.model.currency.Currency;
import com.example.currency.model.currency.CurrencyClient;
import com.example.currency.model.gif.GifClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class ApiController {

    @Value("${giphy.api.richTag}")
    private String rich;
    @Value("${giphy.api.brokeTag}")
    private String broke;

    private final CurrencyClient currencyClient;
    private final GifClient gifClient;

    public ApiController(CurrencyClient currencyClient, GifClient gifClient) {
        this.currencyClient = currencyClient;
        this.gifClient = gifClient;
    }

    @GetMapping("/diff/{date}")
    public ResponseEntity<?> getDifferanceCurrency(@PathVariable("date") String date,
                                                   @RequestParam("symbols") String symbols) {
        Currency latest = currencyClient.getLatest(symbols);
        Currency historical = currencyClient.getHistorical(date, symbols);
        double latestCurrency = latest.getRates().values().stream().mapToDouble(value -> value).sum();
        double historicalCurrency = historical.getRates().values().stream().mapToDouble(value -> value).sum();

        if (latestCurrency > historicalCurrency) {
            return ResponseEntity.ok(gifClient.getRandomGif(rich).getData());
        }
        return ResponseEntity.ok(gifClient.getRandomGif(broke).getData());
    }
}
