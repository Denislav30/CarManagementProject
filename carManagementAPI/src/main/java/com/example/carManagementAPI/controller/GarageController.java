package com.example.carManagementAPI.controller;

import com.example.carManagementAPI.dto.GarageDTO;
import com.example.carManagementAPI.model.Garage;
import com.example.carManagementAPI.service.GarageService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/garages")
public class GarageController {

  private final GarageService garageService;

  public GarageController(GarageService garageService) {
    this.garageService = garageService;
  }

  @GetMapping
  public ResponseEntity<List<GarageDTO>> getAllGarages() {
    return ResponseEntity.ok(garageService.getAllGarages());
  }

  @GetMapping("/{id}")
  public ResponseEntity<GarageDTO> getGarageById(@PathVariable Long id) {
    return ResponseEntity.ok(garageService.getGarageById(id));
  }

  @PostMapping
  public ResponseEntity<Garage> createGarage(@Valid @RequestBody Garage garage) {
    return ResponseEntity.ok(garageService.createGarage(garage));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Garage> updateGarage(@PathVariable Long id, @RequestBody Garage updatedGarage) {
    return ResponseEntity.ok(garageService.updateGarage(id, updatedGarage));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteGarage(@PathVariable Long id) {
    garageService.deleteGarage(id);
    return ResponseEntity.noContent().build();
  }
}
