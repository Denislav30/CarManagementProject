package com.example.carManagementAPI.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class CreateMaintenanceDTO {

  @NotNull(message = "Garage ID cannot be null")
  private Long garageId;

  @NotNull(message = "Car ID cannot be null")
  private Long carId;

  @NotBlank(message = "Service type cannot be blank")
  @Size(max = 50, message = "Service type cannot exceed 50 characters")
  private String serviceType;

  @NotNull(message = "Scheduled date cannot be null")
  @FutureOrPresent(message = "Scheduled date must be today or in the future")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
  private LocalDate scheduledDate;

  public Long getGarageId() {
    return garageId;
  }

  public void setGarageId(Long garageId) {
    this.garageId = garageId;
  }

  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
    this.carId = carId;
  }

  public String getServiceType() {
    return serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }

  public LocalDate getScheduledDate() {
    return scheduledDate;
  }

  public void setScheduledDate(LocalDate scheduledDate) {
    this.scheduledDate = scheduledDate;
  }
}
