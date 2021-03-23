package com.service.forecast.entity.original;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {

  @JsonProperty("3h")
  private double jsonMember3h;

  public double getJsonMember3h() {
    return jsonMember3h;
  }

  public void setJsonMember3h(double jsonMember3h) {
    this.jsonMember3h = jsonMember3h;
  }
}