package com.medic.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.medic.model.EmployeeEntity;
import com.medic.servicemanager.EmployeeManager;
import com.medic.validator.EmployeeValidator;


@Controller
public class EmployeeController
{
	
@Autowired
private EmployeeValidator employeeValidator;

@Autowired
EmployeeManager employeeManager;

@InitBinder
public void initBinder(WebDataBinder binder)
 {
    binder.addValidators(employeeValidator);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	dateFormat.setLenient(false);
	binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
 }

@RequestMapping(value = "/employee.htm",method = RequestMethod.GET)
public EmployeeEntity populateEmployee(Model model, @ModelAttribute("employee") EmployeeEntity employee) 
   { 
	System.out.println(">>>>>>>>>>>>>>> Employee Form >>>>>>>>>");
	
	model.addAttribute("allEmployees",employeeManager.getAllEmployees());
	model.addAttribute("employee", employee);
    return employee;
  }
	

@RequestMapping(value = "/addemployee.htm",method = RequestMethod.POST)
public String addEmployee(Model model, @ModelAttribute("employee") @Valid EmployeeEntity employee,BindingResult result, SessionStatus status) 
   { 
	if(result.hasErrors())
	{
	System.out.println(">>>>>>> result block >>>>>");
	return "employee";
	}
	
	if(employee.getId()>0)
	{
		System.out.println(" Employee Update method call??????");
		employeeManager.addEmployee(employee);
	}
	
	employeeManager.addEmployee(employee);
	System.out.println(">>>>>>>>>>>>>>> post action>>>> Employee Form >>>>>>>>>"+employee.getFirstname());
	model.addAttribute("employee", employee);
    return "redirect:employee.htm" ;
  }
	

@RequestMapping(value = "/editEmployee.htm",method = RequestMethod.GET)
public String updateEmployee(@RequestParam long id, Model model, @ModelAttribute("employee") EmployeeEntity employee) 
   { 
	System.out.println(">>>>>>>>>>>>>>> UPDATE EMPLOYEE DETAILS >>>>>>>>>"+id);
	employee.setId(id);
	
	model.addAttribute("allEmployees",employeeManager.getAllEmployees());
	model.addAttribute("employee",employeeManager.findEmployeeDetailsByID(employee));
	
    return "employee";
  }

@RequestMapping(value = "/deleteEmployee.htm",method = RequestMethod.GET)
public String deleteEmployee(@RequestParam long id, Model model, @ModelAttribute("employee") EmployeeEntity employee) 
   { 
	System.out.println(">>>>>>>>>>>>>>> UPDATE EMPLOYEE DETAILS >>>>>>>>>"+id);
	employee.setId(id);
	
	model.addAttribute("allEmployees",employeeManager.getAllEmployees());
	employeeManager.deleteEmployeeDetailsByID(employee);
	model.addAttribute("allEmployees",employeeManager.getAllEmployees());
	model.addAttribute("employee",employee);
    return "employee";
  }



/*@ModelAttribute("allDepartments")
public List<DepartmentEntity> populateDepartments() 
   {
	
	System.out.println(" Employee Controller call all Department >>>>");
    List<DepartmentEntity> departments = employeeManager.getAllDepartments();
    return departments;
  }*/

/*@ModelAttribute("allEmployees")
public List<EmployeeEntity> populateEmployees() 
{
	System.out.println(" Employee Controller call all Employee >>>>");
    List<EmployeeEntity> employees = employeeManager.getAllEmployees();
    return employees;
}
	
@RequestMapping(value="employee/",method = RequestMethod.GET)
public String setupForm(Model model) 
{
	System.out.println(">>>>>>>> Employee Controller Get Method call >>>>>>>>>>>");
    EmployeeEntity employeeVO = new EmployeeEntity();
    model.addAttribute("employee", employeeVO);
    return "listEmployeeView";
}

@RequestMapping(method = RequestMethod.POST)
public String submitForm(@ModelAttribute("employee") EmployeeEntity employeeVO,
        BindingResult result, SessionStatus status) {

    Set<ConstraintViolation<EmployeeEntity>> violations = validator.validate(employeeVO);
     
    for (ConstraintViolation<EmployeeEntity> violation : violations) 
    {
        String propertyPath = violation.getPropertyPath().toString();
        String message = violation.getMessage();
        // Add JSR-303 errors to BindingResult
        // This allows Spring to display them in view via a FieldError
        result.addError(new FieldError("employee", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
    }

    if (result.hasErrors()) {
        return "listEmployeeView";
    }
    // Store the employee information in database
    employeeManager.addEmployee(employeeVO);
     
    // Mark Session Complete and redirect to URL so that page refresh do not re-submit the form
    status.setComplete();
    return "redirect:employee-module";
}
	*/






}
