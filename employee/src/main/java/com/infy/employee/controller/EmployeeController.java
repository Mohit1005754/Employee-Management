package com.infy.employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employee.dto.EmployeeCreateDto;
import com.infy.employee.dto.EmployeeResponseDto;
import com.infy.employee.dto.LeaveCreateDto;
import com.infy.employee.dto.LeaveResponseDto;
import com.infy.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createEmployeeDetails(@RequestBody EmployeeCreateDto dto){
		try {
			
		//return ResponseEntity.ok(employeeService.createEmployeeDetails(dto));
			 EmployeeResponseDto created = employeeService.createEmployeeDetails(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(created);
		}catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeResponseDto> getEmployeeId(@PathVariable Long id ){
		return ResponseEntity.ok(employeeService.getEmployeeId(id));
	}
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeResponseDto>>getEmployeeDetails(){
		return ResponseEntity.ok(employeeService.getEmloyeeDetails());
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeResponseDto> updateEmployeeDetails(@PathVariable Long id, @RequestBody EmployeeCreateDto dto ){
		return ResponseEntity.ok(employeeService.updateEmployeeDetails(id, dto));
		}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String>deleteEmployeeDetails(@PathVariable Long id) {
		employeeService.deleteEmployeeDetails(id);
		return ResponseEntity.ok("Customer deleted successfully with id: " + id);
		//return ResponseEntity.ok(employeeService
	}
	// leaverequest
	@PostMapping("/create1")
	public ResponseEntity<LeaveResponseDto> createLeaveRequest(@RequestBody LeaveCreateDto dto){
		return ResponseEntity.ok(employeeService.createLeaveRequest(dto));
		
	}
	@GetMapping("/leaves")
	public ResponseEntity<List<LeaveResponseDto>>getAllLeaves(){
		return ResponseEntity.ok(employeeService.getAllLeaves());
	}
	@PutMapping("/updatleaves/{id}")
	public ResponseEntity<LeaveResponseDto> updateLeaveRequest(@PathVariable Long id ,@RequestBody LeaveCreateDto dto){
		return ResponseEntity.ok(employeeService.updateLeaveRequest(id, dto));
		
	}
	@PutMapping("/leaves/{id}/approve")
	public ResponseEntity<LeaveResponseDto> approveLeave(@PathVariable Long id, @RequestBody Map<String, Long> body){
		Long managerId = body.get("managerId");
		LeaveResponseDto res = employeeService.approveLeave(id, managerId);
	    return ResponseEntity.ok(res);
		//return ResponseEntity.ok(employeeService.approveLeave(id, managerId));
		
	}
	
}
