package com.example.currency;

import com.example.currency.model.currency.CurrencyClient;
import com.example.currency.model.gif.GifClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class CurrencyApplicationTests {

    @MockBean
    private CurrencyClient currencyClient;
    private GifClient gifClient;

    @Test
    void currencyClientArgsTest(){
        when(currencyClient.getLatest(Mockito.eq(null))).thenThrow(new RuntimeException("symbols is null"));
    }
    @Test
    void connectionTest() throws Exception{
        Assertions.assertNull(gifClient.getRandomGif("rich"));
    }
}
