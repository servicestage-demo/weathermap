package com.service.forecast.controller;

import java.util.Random;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.forecast.entity.objective.ForecastSummary;
import com.service.forecast.util.CustomException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2017-11-01T10:16:52.801+08:00")

@RestController
@RequestMapping(path = "/forecast", produces = MediaType.APPLICATION_JSON)
@RefreshScope
public class ForecastImpl {
  private static final Logger LOGGER = LoggerFactory.getLogger(ForecastImpl.class);

  @Autowired
  private ForecastImplDelegate userForecastweatherdataDelegate;

  @Autowired
  private Environment environment;

  @Value("${exception.enabled:false}")
  private boolean allowException = false;

  private int getLatencyTime() {
    return environment.getProperty("latency", int.class, 3000);
  }


  @RequestMapping(value = "/show",
      produces = {"application/json"},
      method = RequestMethod.GET)
  public ForecastSummary getForecast(@RequestParam(value = "city", required = true) String city) {
    LOGGER.info("getForecast() is called, city = [{}]", city);
    if (allowException) {
      LOGGER.info("request received");
      Boolean b = new Random().nextBoolean();
      throw new CustomException();
    }
    return userForecastweatherdataDelegate.showForecastWeather(city);
  }

  @RequestMapping(value = "/forecastError",
      produces = {"application/json"},
      method = RequestMethod.GET)
  public String forecastError(HttpServletResponse response) {
    response.setStatus(503);
    System.out.println("-------------------error test");
    return "error test!";
  }
}
