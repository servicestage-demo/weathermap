package com.service.forecast.controller;

import java.util.Random;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.forecast.entity.objective.ForecastSummary;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2017-11-01T10:16:52.801+08:00")

@RestController
@RequestMapping(path = "/forecast", produces = MediaType.APPLICATION_JSON)
public class ForecastImpl {
  private static final Logger LOGGER = LoggerFactory.getLogger(ForecastImpl.class);

  @Autowired
  private ForecastImplDelegate userForecastweatherdataDelegate;

  @Autowired
  private Environment environment;

  private int getLatencyTime() {
    return environment.getProperty("latency", int.class, 3000);
  }


  @RequestMapping(value = "/show",
      produces = {"application/json"},
      method = RequestMethod.GET)
  public ForecastSummary getForecast(@RequestParam(value = "city", required = true) String city) {
    LOGGER.info("getForecast() is called, city = [{}]", city);
    Random random = new Random();
    if (random.nextInt(10) == 0 && getLatencyTime() > 0) {
      try {
        Thread.sleep(getLatencyTime());
      } catch (Exception e) {

      }
    }
    return userForecastweatherdataDelegate.showForecastWeather(city);
  }
}
