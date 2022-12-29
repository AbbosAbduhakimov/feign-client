package com.example.currency.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.Map;

@Configuration
public class CurrencyFeignConfig {
    private static final String APP_ID_KEY = "app_id";
    private static final String BASE_CURRENCY_KEY = "base";
    @Value("${open-exchange-rates.api.appId}")
    private String appId;

    @Value("${open-exchange-rates.api.baseCurrency}")
    private String baseCurrency;

    private static final String API_KEY = "api_key";
    @Value("${giphy.api.app_key}")
    private String apiKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            Map<String, Collection<String>> queries = requestTemplate.queries();
            if (!queries.containsKey(APP_ID_KEY)) {
                requestTemplate.query(APP_ID_KEY, appId);
            }
            if (!queries.containsKey(BASE_CURRENCY_KEY)) {
                requestTemplate.query(BASE_CURRENCY_KEY, baseCurrency);
            }
            if (!queries.containsKey(API_KEY)) {
                requestTemplate.query(API_KEY, apiKey);
            }
        };
    }
}
