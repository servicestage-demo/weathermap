package com.service.weather.controller;

import java.util.Random;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.weather.entity.objective.CurrentWeatherSummary;
import com.service.weather.util.CustomException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2017-11-01T10:26:36.166+08:00")

@RestController
@RequestMapping(path = "/weather", produces = MediaType.APPLICATION_JSON)
public class WeatherImpl {

  private static final Logger LOGGER = LoggerFactory.getLogger(WeatherImpl.class);

  @Autowired
  private WeatherImplDelegate userCurrentweatherdataDelegate;

  @Value("${randomException.enabled}")
  private boolean allowRandomException = true;

  @Value("${timewait.enabled}")
  private boolean timewait = false;

  @Autowired
  private Environment environment;

  private int getLatencyTime() {
    return environment.getProperty("latency", int.class, 3000);
  }

  @RequestMapping(value = "/show",
      produces = {"application/json"},
      method = RequestMethod.GET)
  public CurrentWeatherSummary showCurrentWeather(@RequestParam(value = "city", required = true) String city,
      @RequestParam(value = "user", required = false) String user) {

    Random random = new Random();
    if (allowRandomException && random.nextInt(10) == 0) {
      throw new CustomException();
    }

    if (timewait && getLatencyTime() > 0) {
      try {
        Thread.sleep(getLatencyTime());
      } catch (Exception e) {

      }
    }
    LOGGER.info("showCurrentWeather() is called, city = [{}], user = [{}]", city, user);
    return userCurrentweatherdataDelegate.showCurrentWeather(city);
  }
}
