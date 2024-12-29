package com.example.carManagementAPI.repository;

import com.example.carManagementAPI.model.Maintenance;
import com.sun.tools.javac.Main;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
  List<Maintenance> findByGarageIdAndScheduledDateBetween(Long garageId, LocalDate startDate, LocalDate endDate);
  List<Maintenance> findByCarId(Long carId);
}
