package com.service.fusionweather.entity;

import java.util.List;

public class ForecastWeatherSummary {
  private String country;

  private String cityName;

  private double coordinatesLon;

  private double coordinatesLat;

  private List<DateListItem> dateList;

  private long currentTime = System.currentTimeMillis();

  private String errorMessage;

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public double getCoordinatesLon() {
    return coordinatesLon;
  }

  public void setCoordinatesLon(double coordinatesLon) {
    this.coordinatesLon = coordinatesLon;
  }

  public double getCoordinatesLat() {
    return coordinatesLat;
  }

  public void setCoordinatesLat(double coordinatesLat) {
    this.coordinatesLat = coordinatesLat;
  }

  public List<DateListItem> getDateList() {
    return dateList;
  }

  public void setDateList(List<DateListItem> dateList) {
    this.dateList = dateList;
  }

  public long getCurrentTime() {
    return currentTime;
  }

  public void setCurrentTime(long currentTime) {
    this.currentTime = currentTime;
  }
}