package com.medic.dao;

import java.util.List;

import com.medic.model.*;
public interface EmployeeDAO
{
	public List<EmployeeEntity> getAllEmployees();
	public EmployeeEntity findEmployeeDetailsByID(EmployeeEntity employee);
	
	
    public List<DepartmentEntity> getAllDepartments();
    public void addEmployee(EmployeeEntity employee);
    
    public void deleteEmployeeDetailsByID(EmployeeEntity employee);
	
}
