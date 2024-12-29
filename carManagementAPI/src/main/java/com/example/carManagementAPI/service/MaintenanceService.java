package com.example.carManagementAPI.service;

import com.example.carManagementAPI.dto.MaintenanceDTO;
import com.example.carManagementAPI.model.Car;
import com.example.carManagementAPI.model.Garage;
import com.example.carManagementAPI.model.Maintenance;
import com.example.carManagementAPI.repository.CarRepository;
import com.example.carManagementAPI.repository.GarageRepository;
import com.example.carManagementAPI.repository.MaintenanceRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {

  private final MaintenanceRepository maintenanceRepository;
  private final CarRepository carRepository;
  private final GarageRepository garageRepository;

  public MaintenanceService(MaintenanceRepository maintenanceRepository, CarRepository carRepository,
      GarageRepository garageRepository) {
    this.maintenanceRepository = maintenanceRepository;
    this.carRepository = carRepository;
    this.garageRepository = garageRepository;
  }

  public Maintenance createMaintenance(MaintenanceDTO maintenanceDTO) {
    Car car = carRepository.findById(maintenanceDTO.getCarId())
        .orElseThrow(() -> new RuntimeException("Car not found"));
    Garage garage = garageRepository.findById(maintenanceDTO.getGarageId())
        .orElseThrow(() -> new RuntimeException("Garage not found"));

    Maintenance maintenance = new Maintenance();
    maintenance.setCar(car);
    maintenance.setGarage(garage);
    maintenance.setScheduledDate(maintenanceDTO.getScheduledDate());
    maintenance.setServiceType(maintenanceDTO.getServiceType());

    return maintenanceRepository.save(maintenance);
  }

  public List<MaintenanceDTO> getAllMaintenances(Long garageId, LocalDate startDate, LocalDate endDate) {
    List<Maintenance> maintenances = maintenanceRepository.findByGarageIdAndScheduledDateBetween(garageId, startDate, endDate);

    return maintenances.stream()
        .map(m -> new MaintenanceDTO(
            m.getId(),
            m.getCar().getId(),
            m.getGarage().getId(),
            m.getScheduledDate(),
            m.getServiceType()))
        .collect(Collectors.toList());
  }
}
