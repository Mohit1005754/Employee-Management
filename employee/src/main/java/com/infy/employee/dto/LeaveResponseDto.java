package com.infy.employee.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.infy.employee.enums.LeaveStatus;
import com.infy.employee.enums.LeaveType;

public class LeaveResponseDto {
	private Long id;
	private Long employeeId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	private  LeaveType type;
	private  LeaveStatus status;
	private  LocalDateTime createdAt;
	private Long approveById;
	private LocalDateTime updatedAt;
	

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getApproveById() {
		return approveById;
	}
	public void setApproveById(Long approveById) {
		this.approveById = approveById;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LeaveType getType() {
		return type;
	}
	public void setType(LeaveType type) {
		this.type = type;
	}
	public LeaveStatus getStatus() {
		return status;
	}
	public void setStatus(LeaveStatus status) {
		this.status = status;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	

}
