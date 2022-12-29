package com.example.currency.model.gif;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Gif {
    private String id;
    private String title;
    private String url;
    private String embedUrl;
    private Map<String, Image> images;
}
