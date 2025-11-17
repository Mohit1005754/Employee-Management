package com.infy.employee.dto;

import com.infy.employee.enums.Role;

public class EmployeeCreateDto {
	 private String firstName;
	    private String lastName;
	    private String email;
	    private Long managerId;   // Optional
	    private Role role;
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Long getManagerId() {
			return managerId;
		}
		public void setManagerId(Long managerId) {
			this.managerId = managerId;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}  
	

}
