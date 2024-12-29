package com.example.carManagementAPI.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import jdk.jfr.Enabled;

@Entity
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Make cannot be blank")
  @Size(max = 50, message = "Make cannot exceed 50 characters")
  private String make;

  @NotBlank(message = "Model cannot be blank")
  @Size(max = 50, message = "Model cannot exceed 50 characters")
  private String model;

  @NotNull(message = "Production year cannot be null")
  private int productionYear;

  @NotBlank(message = "License plate cannot be blank")
  private String licensePlate;

  @ManyToOne
  @JoinColumn(name = "garage_id")
  private Garage garage;

  @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Maintenance> maintenances;

  public Garage getGarage() {
    return garage;
  }

  public void setGarage(Garage garage) {
    this.garage = garage;
  }

  public List<Maintenance> getMaintenances() {
    return maintenances;
  }

  public void setMaintenances(List<Maintenance> maintenances) {
    this.maintenances = maintenances;
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

  public int getProductionYear() {
    return productionYear;
  }

  public void setProductionYear(int productionYear) {
    this.productionYear = productionYear;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }
}