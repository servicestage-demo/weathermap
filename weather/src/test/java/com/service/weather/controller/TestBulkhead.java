package com.service.weather.controller;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class TestBulkhead {
  @Test
  public void bulkheadRequest() {
    for (int i = 0; i < 10; i++) {
      new Thread(() -> new RestTemplate().getForObject("http://localhost:13090/weather/show?city=shenzhen", String.class)).start();
    }
  }
}
