package com.service.weather.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.weather.entity.objective.CurrentWeatherSummary;
import com.service.weather.util.CacheUtil;

@Component
public class WeatherImplDelegate {
  @Autowired
  CacheUtil cacheUtil;

  public CurrentWeatherSummary showCurrentWeather(String c) {
    String city = StringUtils.isNotBlank(c) ? c : "shenzhen,cn";
    return cacheUtil.getCurrentWeatherSummary(city);
  }
}
