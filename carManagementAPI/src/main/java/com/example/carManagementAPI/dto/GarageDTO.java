package com.example.carManagementAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import org.apache.catalina.LifecycleState;

public class GarageDTO {
  private Long id;

  @NotBlank(message = "Name cannot be blank")
  @Size(max = 100, message = "Name cannot exceed 100 characters")
  private String name;

  @NotBlank(message = "Location cannot be blank")
  @Size(max = 200, message = "Location cannot exceed 200 characters")
  private String location;

  @NotNull(message = "Capacity cannot be null")
  private int capacity;

  private List<Long> maintenanceIds;

  public List<Long> getMaintenanceIds() {
    return maintenanceIds;
  }

  public void setMaintenanceIds(List<Long> maintenanceIds) {
    this.maintenanceIds = maintenanceIds;
  }

  public GarageDTO() {

  }

  public GarageDTO(Long id, String name, String location, int capacity, List<Long> maintenanceIds) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.capacity = capacity;
    this.maintenanceIds = maintenanceIds;
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
