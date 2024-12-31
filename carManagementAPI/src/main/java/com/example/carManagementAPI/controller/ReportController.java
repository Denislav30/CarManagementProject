package com.example.carManagementAPI.controller;

import com.example.carManagementAPI.dto.MaintenanceReportDTO;
import com.example.carManagementAPI.service.ReportService;
import java.time.YearMonth;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

  private final ReportService reportService;

  private ReportController(ReportService reportService) {
    this.reportService = reportService;
  }

  @GetMapping("/monthlyRequests")
  public ResponseEntity<List<MaintenanceReportDTO>> getMonthlyRequestsReport(
      @RequestParam Long garageId,
      @RequestParam String startMonth,
      @RequestParam String endMonth) {
    YearMonth start = YearMonth.parse(startMonth);
    YearMonth end = YearMonth.parse(endMonth);
    List<MaintenanceReportDTO> report = reportService.getMonthlyRequestsReport(garageId, start, end);
    return ResponseEntity.ok(report);
  }
}
