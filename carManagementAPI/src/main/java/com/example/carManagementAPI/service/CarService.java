package com.example.carManagementAPI.service;

import com.example.carManagementAPI.dto.CarDTO;
import com.example.carManagementAPI.model.Car;
import com.example.carManagementAPI.repository.CarRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  private final CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<CarDTO> getAllCars() {
    return carRepository.findAll().stream()
        .map(car -> new CarDTO(car.getId(), car.getMake(), car.getModel()))
        .collect(Collectors.toList());
  }

  public CarDTO getCarById(Long id) {
    Car car = carRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Car not found"));
    return new CarDTO(car.getId(), car.getMake(), car.getModel());
  }

  public Car createCar(Car car) {
    return carRepository.save(car);
  }

  public Car updateCar(Long id, Car updatedCar) {
    Car car = carRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Car not found"));
    car.setMake(updatedCar.getMake());
    car.setModel(updatedCar.getModel());
    car.setProductionYear(updatedCar.getProductionYear());
    car.setLicensePlate(updatedCar.getLicensePlate());
    return carRepository.save(car);
  }

  public void deleteCar(Long id) {
    if (!carRepository.existsById(id)) {
      throw new RuntimeException("Car not found");
    }
    carRepository.deleteById(id);
  }
}
