package com.example.carManagementAPI.repository;

import com.example.carManagementAPI.dto.MaintenanceReportDTO;
import com.example.carManagementAPI.model.Maintenance;
import com.sun.tools.javac.Main;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
  List<Maintenance> findByGarageIdAndScheduledDateBetween(Long garageId, LocalDate startDate, LocalDate endDate);
  List<Maintenance> findByCarId(Long carId);
  @Query("SELECT new com.example.carManagementAPI.dto.MaintenanceReportDTO(m.garage.id, FUNCTION('YEAR', m.scheduledDate), FUNCTION('MONTH', m.scheduledDate), COUNT(m)) " +
      "FROM Maintenance m " +
      "WHERE m.garage.id = :garageId " +
      "AND m.scheduledDate BETWEEN :startDate AND :endDate " +
      "GROUP BY m.garage.id, FUNCTION('YEAR', m.scheduledDate), FUNCTION('MONTH', m.scheduledDate)")
  List<MaintenanceReportDTO> findMonthlyMaintenanceReport(
      @Param("garageId") Long garageId,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate);
}
