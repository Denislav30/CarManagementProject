package com.example.carManagementAPI.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.YearMonth;

public class MaintenanceReportDTO {

  private Long garageId;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm")
  private YearMonth month;

  private int totalRequests;

  public Long getGarageId() {
    return garageId;
  }

  public void setGarageId(Long garageId) {
    this.garageId = garageId;
  }

  public YearMonth getMonth() {
    return month;
  }

  public void setMonth(YearMonth month) {
    this.month = month;
  }

  public int getTotalRequests() {
    return totalRequests;
  }

  public void setTotalRequests(int totalRequests) {
    this.totalRequests = totalRequests;
  }
}
