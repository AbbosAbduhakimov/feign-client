package com.example.currency.model.gif;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://api.giphy.com/v1/gifs",name = "random-gif-client")
public interface GifClient {

    @GetMapping("/random")
    RandomGif getRandomGif(@RequestParam("tag") String tag);
}
