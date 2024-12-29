package com.example.carManagementAPI.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
public class Garage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name cannot be blank")
  @Size(max = 100, message = "Name cannot exceed 100 characters")
  private String name;

  @NotBlank(message = "Location cannot be blank")
  @Size(max = 200, message = "Location cannot exceed 200 characters")
  private String location;

  @NotNull(message = "Capacity cannot be null")
  private int capacity;

  @OneToMany(mappedBy = "garage")
  private List<Car> cars;

  @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Maintenance> maintenances;

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
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

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
}
