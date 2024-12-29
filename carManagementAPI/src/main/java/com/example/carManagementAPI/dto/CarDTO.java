package com.example.carManagementAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class CarDTO {
  private Long id;

  @NotBlank(message = "Make cannot be blank")
  @Size(max = 50, message = "Make cannot exceed 50 characters")
  private String make;

  @NotBlank(message = "Model cannot be blank")
  @Size(max = 50, message = "Model cannot exceed 50 characters")
  private String model;

  @NotNull(message = "Production year cannot be null")
  private Integer productionYear;

  @NotNull(message = "License plate cannot be blank")
  private String licensePlate;

  private List<Long> maintenanceIds;

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

  public List<Long> getMaintenanceIds() {
    return maintenanceIds;
  }

  public void setMaintenanceIds(List<Long> maintenanceIds) {
    this.maintenanceIds = maintenanceIds;
  }

  public CarDTO() {

  }

  public CarDTO(Long id, String make, String model) {
    this.id = id;
    this.make = make;
    this.model = model;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
}
