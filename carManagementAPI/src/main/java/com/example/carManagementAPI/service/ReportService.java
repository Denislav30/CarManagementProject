package com.example.carManagementAPI.service;

import com.example.carManagementAPI.dto.MaintenanceDTO;
import com.example.carManagementAPI.dto.MaintenanceReportDTO;
import com.example.carManagementAPI.repository.MaintenanceRepository;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

  private final MaintenanceRepository maintenanceRepository;

  public ReportService(MaintenanceRepository maintenanceRepository) {
    this.maintenanceRepository = maintenanceRepository;
  }

  public List<MaintenanceReportDTO> getMonthlyRequestsReport(Long garageId, YearMonth startMonth, YearMonth endMonth) {
    LocalDate startDate = startMonth.atDay(1);
    LocalDate endDate = endMonth.atEndOfMonth();
    return maintenanceRepository.findMonthlyMaintenanceReport(garageId, startDate, endDate);
  }

}
