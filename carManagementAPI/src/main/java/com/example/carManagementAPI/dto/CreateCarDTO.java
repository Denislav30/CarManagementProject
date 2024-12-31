package com.example.carManagementAPI.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateCarDTO {

  @NotBlank(message = "Make cannot be blank")
  @Size(max = 50, message = "Make cannot exceed 50 characters")
  private String make;

  @NotBlank(message = "Model cannot be blank")
  @Size(max = 50, message = "Model cannot exceed 50 characters")
  private String model;

  @NotNull(message = "Production year cannot be null")
  @Min(value = 1886, message = "Production year cannot be earlier than 1886")
  @Max(value = 2100, message = "Production year is invalid")
  private Integer productionYear;

  @NotBlank(message = "License plate cannot be blank")
  @Size(max = 20, message = "License plate cannot exceed 20 characters")
  private String licensePlate;

  @NotNull(message = "Garage ID list cannot be null")
  private Long[] garageIds;

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getProductionYear() {
    return productionYear;
  }

  public void setProductionYear(Integer productionYear) {
    this.productionYear = productionYear;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public Long[] getGarageIds() {
    return garageIds;
  }

  public void setGarageIds(Long[] garageIds) {
    this.garageIds = garageIds;
  }
}
