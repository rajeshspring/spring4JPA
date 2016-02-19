package com.medic.servicemanager;

import java.util.List;

import com.medic.model.DepartmentEntity;
import com.medic.model.EmployeeEntity;

public interface EmployeeManager 
{
	public List<EmployeeEntity> getAllEmployees();
	public EmployeeEntity findEmployeeDetailsByID(EmployeeEntity employee);
	
    public List<DepartmentEntity> getAllDepartments();
    public void addEmployee(EmployeeEntity employee);
    
    public void deleteEmployeeDetailsByID(EmployeeEntity employee);
}
