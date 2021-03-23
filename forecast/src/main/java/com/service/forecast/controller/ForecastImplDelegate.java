package com.service.forecast.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.forecast.entity.objective.ForecastSummary;
import com.service.forecast.util.CacheUtil;

@Component
public class ForecastImplDelegate {
  @Autowired
  CacheUtil cacheUtil;

  public ForecastSummary showForecastWeather(String c) {
    String city = StringUtils.isNotBlank(c) ? c : "ShenZhen,CN";
    return cacheUtil.getForecastWeatherSummary(city);
  }
}
