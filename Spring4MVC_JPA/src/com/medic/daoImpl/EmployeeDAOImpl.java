package com.medic.daoImpl;

import com.medic.dao.EmployeeDAO;
import com.medic.model.DepartmentEntity;
import com.medic.model.EmployeeEntity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO
  {

	@PersistenceContext
	private EntityManager manager;
	
		
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		// TODO Auto-generated method stub
		
		
		List<EmployeeEntity> employees = manager.createQuery("Select a From EmployeeEntity a",EmployeeEntity.class).getResultList();
		return employees;
	}
	
	@Override
	public EmployeeEntity findEmployeeDetailsByID(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		employee=manager.find(EmployeeEntity.class, employee.getId());
		
		System.out.println(">>>>>>>>>>>>>>> find employee details by employee ID >>>>>>>>"+employee.getFirstname());
		return employee;
	}

	@Override
	public List<DepartmentEntity> getAllDepartments() {
		// TODO Auto-generated method stub
		List<DepartmentEntity> depts = manager.createQuery("Select a From test.DepartmentEntity a", DepartmentEntity.class).getResultList();
		return depts;
	}
	
	public DepartmentEntity getDepartmentById(Integer id) 
    {
        return manager.find(DepartmentEntity.class, id);
    }

	@Override
	public void addEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		
		if(employee.getId()>0)
		{
		System.out.println(">>>>>>>>>>>>>>> Employee Data Updated >>>>>>> ");
		manager.merge(employee);
		}
		else
		{
		System.out.println(">>>>>>>>>>>>>>> Employee Data Save >>>>>>> ");		
        manager.persist(employee);
		}
	}

	@Override
	public void deleteEmployeeDetailsByID(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		
		System.out.println(" remove Employee object from Employee DAOIMPL class >>>>>>>>>>>");
		
		EmployeeEntity employee1 = manager.find(EmployeeEntity.class, employee.getId());
		manager.remove(employee1);
		
	}

	

	

	

}
