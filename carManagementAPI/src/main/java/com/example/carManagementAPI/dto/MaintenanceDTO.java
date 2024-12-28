package com.example.carManagementAPI.dto;

import java.time.LocalDate;

public class MaintenanceDTO {
  private Long id;
  private Long carId;
  private Long garageId;
  private LocalDate scheduledDate;
  private String serviceType;

  public MaintenanceDTO() {

  }

  public MaintenanceDTO(Long id, Long carId, Long garageId, LocalDate scheduledDate, String serviceType) {
    this.id = id;
    this.carId = carId;
    this.garageId = garageId;
    this.scheduledDate = scheduledDate;
    this.serviceType = serviceType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
    this.carId = carId;
  }

  public Long getGarageId() {
    return garageId;
  }

  public void setGarageId(Long garageId) {
    this.garageId = garageId;
  }

  public LocalDate getScheduledDate() {
    return scheduledDate;
  }

  public void setScheduledDate(LocalDate scheduledDate) {
    this.scheduledDate = scheduledDate;
  }

  public String getServiceType() {
    return serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }
}
