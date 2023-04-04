package com.service.forecast.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.service.forecast.entity.objective.ForecastSummary;

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

  public ForecastSummary getForecastWeatherSummary(String kk) {
    try {
      if(redisEnabled) {
        Object o = redisUtil.get("ForecastSummary_" + kk);
        if(o != null) {
          String vs = o.toString();
          return mapper.readValue(vs, ForecastSummary.class);
        }

        ForecastSummary su = openWeatherMapClient.showForecastWeather(kk);
        String sus = mapper.writeValueAsString(su);
        redisUtil.set("ForecastSummary_" + kk, sus);
        return su;
      }

      return openWeatherMapClient.showForecastWeather(kk);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
