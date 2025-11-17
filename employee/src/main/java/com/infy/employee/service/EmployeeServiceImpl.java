package com.infy.employee.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.employee.dto.EmployeeCreateDto;
import com.infy.employee.dto.EmployeeResponseDto;
import com.infy.employee.dto.LeaveCreateDto;
import com.infy.employee.dto.LeaveResponseDto;
import com.infy.employee.entity.Employee;
import com.infy.employee.entity.LeaveRequest;
import com.infy.employee.enums.LeaveStatus;
import com.infy.employee.enums.LeaveType;
import com.infy.employee.enums.Role;
import com.infy.employee.repository.EmployeeRepository;
import com.infy.employee.repository.LeaveRequestRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepo;
	@Autowired
	private LeaveRequestRepository leaveRepo;

	@Override
	public EmployeeResponseDto createEmployeeDetails(EmployeeCreateDto dto) {
		Employee emp = new Employee();
		emp.setFirstName(dto.getFirstName());
		emp.setLastName(dto.getLastName());
		emp.setEmail(dto.getEmail());
		//emp.setEmail(dto.getEmail());
		//emp.setManager(dto.getManagerId());
		if(dto.getManagerId() != null) {
			Employee manager = employeeRepo.findById(dto.getManagerId()).orElseThrow(()-> new RuntimeException("manager not found"));
			emp.setManager(manager);
			
		}
		emp.setRole(dto.getRole());
		emp.setCreatedAt(LocalDateTime.now());
		 
		Employee saved = employeeRepo.save(emp);
		
		EmployeeResponseDto res = new EmployeeResponseDto();
		res.setId(saved.getId());
		res.setFirstName(saved.getFirstName());
		res.setLastName(saved.getLastName());
		//res.setManagerId(saved.getManager());
		if(saved.getManager()!= null) {
			res.setManagerId(saved.getManager().getId());
			
		}
		else {
			res.setManagerId(null);
		}
		res.setRole(saved.getRole());
		res.setCreatedAt(saved.getCreatedAt());
		res.setEmail(saved.getEmail());
		
		return res;
	}

	@Override
	public EmployeeResponseDto getEmployeeId(Long id) {
		//Employee emp = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("employee not found"));
		Employee emp = employeeRepo.findById(id).orElse(null);
		EmployeeResponseDto er = new EmployeeResponseDto();
		er.setId(emp.getId());
		er.setFirstName(emp.getFirstName());
		er.setLastName(emp.getLastName());
		er.setEmail(emp.getEmail());
		//er.setManagerId(emp.getManager());
		if(emp.getManager() != null) {
			er.setManagerId(emp.getManager().getId());
		}
		else {
			er.setManagerId(null);
		}
		er.setRole(emp.getRole());
		er.setCreatedAt(emp.getCreatedAt());
		
		// TODO Auto-generated method stub
		return er;
	}

	@Override
	public List<EmployeeResponseDto> getEmloyeeDetails() {
		// TODO Auto-generated method stub
		//EmployeeResponseDto ey = new EmployeeResponseDto()
		List<Employee> emp = employeeRepo.findAll();
		
		
		return emp.stream().map(e -> {
			EmployeeResponseDto ey = new EmployeeResponseDto();
			ey.setId(e.getId());
			ey.setFirstName(e.getFirstName());
			ey.setLastName(e.getLastName());
			ey.setEmail(e.getEmail());
			ey.setCreatedAt(e.getCreatedAt());
			ey.setRole(e.getRole());
			if(e.getManager() != null) {
				ey.setManagerId(e.getManager().getId());
			}
			else {
				ey.setManagerId(null);
			}
			return ey;
		}).collect(Collectors.toList());
	}

	@Override
	public EmployeeResponseDto updateEmployeeDetails(Long id, EmployeeCreateDto dto) {
		//Employee emp = employeeRepo.findById(id).orElseThrow(()-> new RunTimeException("employess not found"));
		//Employee emp = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("employee not found"));
		Employee emp = employeeRepo.findById(id).orElse(null);
		//EmployeeResponseDto ed = new EmployeeResponseDto();
		emp.setFirstName(dto.getFirstName());
		emp.setLastName(dto.getLastName());
		emp.setEmail(dto.getEmail());
		emp.setCreatedAt(LocalDateTime.now());
		if(dto.getManagerId() != null) {
			Employee manager = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("manager not found"));
			
			emp.setManager(manager);
			}
		Employee saved = employeeRepo.save(emp);
		EmployeeResponseDto ed = new EmployeeResponseDto();
		ed.setId(saved.getId());
		ed.setFirstName(saved.getFirstName());
		ed.setLastName(saved.getLastName());
		ed.setRole(saved.getRole());
		ed.setCreatedAt(saved.getCreatedAt());
		ed.setEmail(saved.getEmail());
		if(saved.getManager() != null) {
			ed.setManagerId(saved.getManager().getId());
			
		}else {
			ed.setManagerId(null);
		}
		
		return ed;
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployeeDetails(Long id) {
		Employee emp = employeeRepo.findById(id).orElseThrow(()-> new RuntimeException("employee id not found" +id));
		employeeRepo.delete(emp);
		
		
		
	}

	@Override
	public LeaveResponseDto createLeaveRequest(LeaveCreateDto dto) {
		LeaveRequest leave = new LeaveRequest();
		leave.setStartDate(dto.getStartDate());
		leave.setEndDate(dto.getEndDate());
		leave.setType(LeaveType.ANNUAL);
		leave.setReason(dto.getReason());
		if(dto.getEmployeeId() != null) {
			Employee employee = employeeRepo.findById(dto.getEmployeeId()).orElseThrow(() -> new RuntimeException("employee is not found"));
			leave.setEmployee(employee);
			
		}
		leave.setStatus(LeaveStatus.PENDING);
		leave.setCreatedAt(LocalDateTime.now());
		
		LeaveRequest saved = leaveRepo.save(leave);
		
		LeaveResponseDto ld = new LeaveResponseDto();
	ld.setId(saved.getId());
	ld.setStartDate(saved.getStartDate());
	ld.setEndDate(saved.getEndDate());
	ld.setCreatedAt(saved.getCreatedAt());
	ld.setReason(saved.getReason());
	ld.setCreatedAt(saved.getCreatedAt());
	ld.setStatus(saved.getStatus());
	ld.setType(saved.getType());
	if(saved.getEmployee() != null) {
		ld.setEmployeeId(saved.getEmployee().getId());
		
	}else {
		ld.setEmployeeId(null);
	}
		
		return ld;
	}

	@Override
	public List<LeaveResponseDto> getAllLeaves() {
		List<LeaveRequest> lr = leaveRepo.findAll();
//		return lr.stream().map(l -> {
//			LeaveResponseDto dto = new LeaveResponseDto();
//			dto.setId(l.getId());
//			dto.setStartDate(l.getStartDate());
//			dto.setEndDate(l.getEndDate());
//			dto.setCreatedAt(l.getCreatedAt());
//			dto.setReason(l.getReason());
//			dto.setStatus(l.getStatus());
//			dto.setType(l.getType());
//			if(l.getEmployee() != null) {
//				dto.setEmployeeId(l.getEmployee().getId());
//			} else {
//				dto.setEmployeeId(null);
//			}
//			return dto }).collect(Collectors.toList());
////		
//		@Override
//		public List<LeaveResponseDto> getAllLeaves() {
//		    List<LeaveRequest> lr = leaveRepo.findAll();

		    return lr.stream().map(l -> {
		        LeaveResponseDto dto = new LeaveResponseDto();
		        dto.setId(l.getId());
		        dto.setStartDate(l.getStartDate());
		        dto.setEndDate(l.getEndDate());
		        dto.setCreatedAt(l.getCreatedAt());
		        dto.setReason(l.getReason());
		        dto.setStatus(l.getStatus());
		        dto.setType(l.getType());

		        if (l.getEmployee() != null) {
		            dto.setEmployeeId(l.getEmployee().getId());
		        } else {
		            dto.setEmployeeId(null); 
		        }

		        return dto; // <-- must return the dto from the lambda
		    }).collect(Collectors.toList());
		}

	@Override
	public LeaveResponseDto updateLeaveRequest(Long id, LeaveCreateDto dto) {
		LeaveRequest leaveRequest = leaveRepo.findById(id).orElseThrow(() -> new RuntimeException ("employee not found"));
		leaveRequest.setCreatedAt(LocalDateTime.now());
		leaveRequest.setStartDate(dto.getStartDate());
		leaveRequest.setEndDate(dto.getEndDate());
		leaveRequest.setReason(dto.getReason());
		leaveRequest.setType(LeaveType.SICK);
		if(dto.getEmployeeId() != null) {
			Employee employee = employeeRepo.findById(dto.getEmployeeId()).orElseThrow(() -> new RuntimeException ("employee not found"));
			leaveRequest.setEmployee(employee);
		}else {
			leaveRequest.setEmployee(null);
		}
		leaveRequest.setStatus(LeaveStatus.APPROVED);
		LeaveRequest saved = leaveRepo.save(leaveRequest);
		
		
		LeaveResponseDto lrdt = new LeaveResponseDto();
		lrdt.setId(saved.getId());
		lrdt.setType(saved.getType());
		lrdt.setCreatedAt(saved.getCreatedAt());
		lrdt.setStartDate(saved.getStartDate());
		lrdt.setEndDate(saved.getEndDate());
		lrdt.setStatus(saved.getStatus());
		lrdt.setReason(saved.getReason());
		if(saved.getEmployee() != null) {
			lrdt.setEmployeeId(saved.getEmployee().getId());
		}
		else {
			lrdt.setEmployeeId(null);
		}
		// TODO Auto-generated method stub
		return lrdt;
	}

	@Override
	public LeaveResponseDto approveLeave(Long leaveId, Long managerId) {
		LeaveRequest leaveRequest = leaveRepo.findById(leaveId).orElseThrow(() -> new IllegalArgumentException("Leave not found with ID: " + leaveId));
		// TODO Auto-generated method stub
		if(leaveRequest.getStatus() != LeaveStatus.PENDING) {
			throw new IllegalArgumentException("Leave already" + leaveRequest.getStatus());
			
		}
		Employee manager = employeeRepo.findById(managerId).orElseThrow(() -> new IllegalArgumentException("Manage not found with ID: " + managerId));
//	     if(manager.getRole() != Role.MANAGER) {
//	    	 throw new IllegalArgumentException("Given employee is not a manager");
//	     }
	     leaveRequest.setStatus(LeaveStatus.APPROVED);
	     leaveRequest.setApproveBy(manager);
	     leaveRequest.setUpdatedAt(LocalDateTime.now());
	     
	     LeaveRequest saved = leaveRepo.save(leaveRequest);
	     LeaveResponseDto dto = new LeaveResponseDto();
	     dto.setId(saved.getId());
	     dto.setStartDate(saved.getStartDate());
	     dto.setEndDate(saved.getEndDate());
	     dto.setReason(saved.getReason());
	     dto.setStatus(saved.getStatus());
	     dto.setType(saved.getType());
	     dto.setCreatedAt(saved.getCreatedAt());
	     dto.setUpdatedAt(saved.getUpdatedAt()); 
	   //  dto.setUpdatedAt(saved.getUpdatedAt());
	     if(saved.getEmployee() != null) {
	    	 dto.setEmployeeId(saved.getEmployee().getId());
	     }
	     if(saved.getApproveBy() != null) {
	    	// dto.setApproveBy(saved.getApproveBy().getId());
	    	 dto.setApproveById(saved.getApproveBy().getId());
	    	 
	    	 
	     }
	     return dto;
	}
	}

	
	

	
	


