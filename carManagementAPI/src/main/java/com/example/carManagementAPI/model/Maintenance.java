package com.example.carManagementAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Maintenance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @NotNull(message = "Car cannot be null")
  private Car car;

  @ManyToOne
  @NotNull(message = "Garage cannot be null")
  private Garage garage;

  @NotNull(message = "Scheduled date cannot be null")
  @Future(message = "Scheduled date must be in the future")
  private LocalDate scheduledDate;

  @NotBlank(message = "Service type cannot be blank")
  private String serviceType;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Garage getGarage() {
    return garage;
  }

  public void setGarage(Garage garage) {
    this.garage = garage;
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
