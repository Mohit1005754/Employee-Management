package com.infy.employee.service;

import java.util.List;

import com.infy.employee.dto.EmployeeCreateDto;
import com.infy.employee.dto.EmployeeResponseDto;
import com.infy.employee.dto.LeaveCreateDto;
import com.infy.employee.dto.LeaveResponseDto;

public interface EmployeeService {
	public EmployeeResponseDto createEmployeeDetails(EmployeeCreateDto dto);
	public EmployeeResponseDto getEmployeeId(Long id);
	public List<EmployeeResponseDto> getEmloyeeDetails();
	public EmployeeResponseDto updateEmployeeDetails(Long id,EmployeeCreateDto dto);
	public void deleteEmployeeDetails(Long id);
	public LeaveResponseDto createLeaveRequest(LeaveCreateDto dto);
	public List<LeaveResponseDto>getAllLeaves();
	public LeaveResponseDto updateLeaveRequest(Long id, LeaveCreateDto dto);
	public LeaveResponseDto approveLeave(Long LeaveId, Long ManagerId);

}
