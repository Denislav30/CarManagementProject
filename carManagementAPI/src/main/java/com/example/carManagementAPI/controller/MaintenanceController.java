package com.example.carManagementAPI.controller;

import com.example.carManagementAPI.dto.MaintenanceDTO;
import com.example.carManagementAPI.service.MaintenanceService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maintenances")
public class MaintenanceController {

  private final MaintenanceService maintenanceService;

  public MaintenanceController(MaintenanceService maintenanceService) {
    this.maintenanceService = maintenanceService;
  }

  @PostMapping
  public ResponseEntity<?> createMaintenance(@Valid @RequestBody MaintenanceDTO maintenanceDTO) {
    return ResponseEntity.ok(maintenanceService.createMaintenance(maintenanceDTO));
  }

  @GetMapping
  public ResponseEntity<List<MaintenanceDTO>> getAllMaintenances(
      @RequestParam Long garageId,
      @RequestParam LocalDate startDate,
      @RequestParam LocalDate endDate) {
    return ResponseEntity.ok(maintenanceService.getAllMaintenances(garageId, startDate, endDate));
  }
}
