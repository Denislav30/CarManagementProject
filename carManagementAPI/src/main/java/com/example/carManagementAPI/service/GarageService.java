package com.example.carManagementAPI.service;

import com.example.carManagementAPI.dto.GarageDTO;
import com.example.carManagementAPI.model.Garage;
import com.example.carManagementAPI.repository.GarageRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class GarageService {

  private final GarageRepository garageRepository;

  public GarageService(GarageRepository garageRepository) {
    this.garageRepository = garageRepository;
  }

  public List<GarageDTO> getAllGarages() {
    return garageRepository.findAll().stream()
        .map(garage -> new GarageDTO(
            garage.getId(),
            garage.getName(),
            garage.getLocation(),
            garage.getCapacity()))
        .collect(Collectors.toList());
  }

  public GarageDTO getGarageById(Long id) {
    Garage garage = garageRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Garage not found"));
    return new GarageDTO(garage.getId(), garage.getName(), garage.getLocation(), garage.getCapacity());
  }

  public Garage createGarage(Garage garage) {
    return garageRepository.save(garage);
  }

  public Garage updateGarage(Long id, Garage updatedGarage) {
    Garage garage = garageRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Garage not found"));
    garage.setName(updatedGarage.getName());
    garage.setLocation(updatedGarage.getLocation());
    garage.setCapacity(updatedGarage.getCapacity());
    return garageRepository.save(garage);
  }

  public void deleteGarage(Long id) {
    if (!garageRepository.existsById(id)) {
      throw new RuntimeException("Garage not found");
    }
    garageRepository.deleteById(id);
  }
}
