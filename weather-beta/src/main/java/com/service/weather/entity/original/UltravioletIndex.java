package com.service.weather.entity.original;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UltravioletIndex {

  @JsonProperty("date")
  private int date;

  @JsonProperty("date_iso")
  private String dateIso;

  @JsonProperty("lon")
  private double lon;

  @JsonProperty("value")
  private double value;

  @JsonProperty("lat")
  private double lat;

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }

  public String getDateIso() {
    return dateIso;
  }

  public void setDateIso(String dateIso) {
    this.dateIso = dateIso;
  }

  public double getLon() {
    return lon;
  }

  public void setLon(double lon) {
    this.lon = lon;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }
}