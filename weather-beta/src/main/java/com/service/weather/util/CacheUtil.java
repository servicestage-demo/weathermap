package com.service.weather.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.service.weather.entity.objective.CurrentWeatherSummary;

/**
 * Cache
 */
@Component
public class CacheUtil {
  private static final Logger LOGGER = LoggerFactory.getLogger(CacheUtil.class);

  private static final int TIME_SPAN = 1800 * 1000;

  @Value("${REDIS_ENABLED:false}")
  private boolean redisEnabled = false;

  @Autowired
  private RedisUtil redisUtil;

  @Autowired
  private OpenWeatherMapClient openWeatherMapClient;

  private static final ObjectMapper mapper = new ObjectMapper();

  public CurrentWeatherSummary getCurrentWeatherSummary(String kk) {
    try {
      if(redisEnabled) {
        Object o = redisUtil.get("CurrentWeatherBetaSummary_" + kk);
        if(o != null) {
          String vs = o.toString();
          return mapper.readValue(vs, CurrentWeatherSummary.class);
        }

        CurrentWeatherSummary su = openWeatherMapClient.showCurrentWeather(kk);
        String sus = mapper.writeValueAsString(su);
        redisUtil.set("CurrentWeatherBetaSummary_" + kk, sus);
        return su;
      }

      return openWeatherMapClient.showCurrentWeather(kk);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
