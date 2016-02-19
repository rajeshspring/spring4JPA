package com.medic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.medic.model.BankDetails;
@Controller 
public class BankController
{
	@RequestMapping(value = "/addBankDetails.htm",method = RequestMethod.GET)
	public BankDetails populateEmployee(Model model, @ModelAttribute("employee") BankDetails BankDetails) 
	   { 
		System.out.println(">>>>>>>>>>>>>>> Add bank details >>>>>>>>>");
		
		
		model.addAttribute("BankDetails", BankDetails);
	    return BankDetails;
	  }
}
