package com.example.carManagementAPI.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateGarageDTO {

  @NotBlank(message = "Name cannot be blank")
  @Size(max = 100, message = "Name cannot exceed 100 characters")
  private String name;

  @NotBlank(message = "Location cannot be blank")
  @Size(max = 200, message = "Location cannot exceed 200 characters")
  private String location;

  @NotBlank(message = "City cannot be blank")
  @Size(max = 100, message = "City cannot exceed 100 characters")
  private String city;

  @NotNull(message = "Capacity cannot be null")
  @Min(value = 1, message = "Capacity must be at least 1")
  private Integer capacity;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }
}
