package com.service.fusionweather.controller;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.service.fusionweather.entity.CurrentWeatherSummary;
import com.service.fusionweather.entity.ForecastWeatherSummary;
import com.service.fusionweather.entity.FusionWeatherSummary;

import io.vertx.core.json.Json;

@Component
public class FusionweatherImplDelegate {
  private static final Logger LOGGER = LoggerFactory.getLogger(FusionweatherImplDelegate.class);

  @Autowired
  RestTemplate restTemplate;

  public FusionWeatherSummary showFusionWeather(String city, String user) {
    FusionWeatherSummary summary = new FusionWeatherSummary();
    summary.setCurrentWeather(achieveCurrentWeatherSummary(city, user));
    summary.setForecastWeather(achieveForecastWeatherSummary(city));

    return summary;
  }

  private CurrentWeatherSummary achieveCurrentWeatherSummary(String city, String user) {
    CurrentWeatherSummary su;
    try {
      Object s = restTemplate.getForObject("http://weather/weather/show?city=" + city + "&user=" + user,
          Object.class, new Object());
      su = Json.decodeValue(Json.encode(s), CurrentWeatherSummary.class);
    } catch (Exception e) {
      LOGGER.error("FusionWeatherDataDelegate>> Failed to achieve the current weather summary", e);
      return null;
    }
    return su;
  }

  private ForecastWeatherSummary achieveForecastWeatherSummary(String city) {
    final String url = "http://forecast/forecast/show?city=" + city;
    ForecastWeatherSummary su;
    try {
      Object s = restTemplate.getForObject(url, Object.class, new Object());
      su = Json.decodeValue(Json.encode(s), ForecastWeatherSummary.class);
    } catch (Exception e) {
      LOGGER.error("FusionWeatherDataDelegate>> Failed to achieve the forecast weather summary", e);
      su = new ForecastWeatherSummary();
      su.setErrorMessage(settingErrorMessage(e));
    }
    return su;
  }

  private String settingErrorMessage(Exception exception) {
    if (exception instanceof HttpClientErrorException) {
      HttpClientErrorException errorException = (HttpClientErrorException) exception;
      if (errorException.getStatusCode().value() == 429) {
        return "TOO MANY REQUESTS!";
      }
    }
    if (exception instanceof HttpServerErrorException) {
      // INSTANCE ISOLATION
      HttpServerErrorException errorException = (HttpServerErrorException) exception;
      if (errorException.getStatusCode().value() == 503 || errorException.getStatusCode().value() == 502) {
        return errorException.getStatusText().toUpperCase(Locale.ROOT);
      }
    }
    return "";
  }

  public String forecastError() {
    return restTemplate.getForObject("http://forecast/forecast/forecastError", String.class);
  }
}
