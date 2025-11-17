package com.infy.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.employee.entity.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long>{
	

}
