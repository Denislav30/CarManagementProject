package com.example.carManagementAPI.controller;

import com.example.carManagementAPI.dto.CarDTO;
import com.example.carManagementAPI.model.Car;
import com.example.carManagementAPI.service.CarService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping
  public ResponseEntity<List<CarDTO>> getAllCars() {
    return ResponseEntity.ok(carService.getAllCars());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CarDTO> getCarById(@PathVariable Long id) {
    return ResponseEntity.ok(carService.getCarById(id));
  }

  @PostMapping
  public ResponseEntity<Car> createCar(@RequestBody Car car) {
    return ResponseEntity.ok(carService.createCar(car));
  }

  @PostMapping("/{id}")
  public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
    return ResponseEntity.ok(carService.updateCar(id, updatedCar));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
    carService.deleteCar(id);
    return ResponseEntity.noContent().build();
  }
}
