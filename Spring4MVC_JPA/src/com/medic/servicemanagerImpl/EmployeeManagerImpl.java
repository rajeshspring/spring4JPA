package com.medic.servicemanagerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.medic.dao.EmployeeDAO;
import com.medic.model.DepartmentEntity;
import com.medic.model.EmployeeEntity;
import com.medic.servicemanager.EmployeeManager;


public class EmployeeManagerImpl implements EmployeeManager
{
	
	@Autowired
    EmployeeDAO employeedao;
     

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeedao.getAllEmployees();
	}

	@Override
	public List<DepartmentEntity> getAllDepartments() {
		// TODO Auto-generated method stub
		return employeedao.getAllDepartments();
	}

	@Override
	public void addEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		employeedao.addEmployee(employee);
	}

	@Override
	public EmployeeEntity findEmployeeDetailsByID(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		return employeedao.findEmployeeDetailsByID(employee);
	}

	@Override
	public void deleteEmployeeDetailsByID(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		
		employeedao.deleteEmployeeDetailsByID(employee);
	}

	

}
