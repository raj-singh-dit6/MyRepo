package com.CRUDMVC.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.CRUDMVC.model.Employee;
import com.CRUDMVC.model.empDao;

@Controller
public class empFormControllers {
	
	empDao dao;
	
	@RequestMapping(value="/EmployeeForm")
	public ModelAndView EmployeeForm()
	{
		return  new ModelAndView("addEmpForm","command",new Employee());
	}
	
	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	public ModelAndView addEmp(@ModelAttribute("emp")Employee emp)
	{
		dao.addEmployee(emp);
		return new ModelAndView("redirect:viewEmp");
	}
	
	@RequestMapping(value="/viewEmp")
	public ModelAndView viewEmp()
	{
		List<Employee> list=dao.getAllEmployeeDetails();
		return new ModelAndView("viewEmp","listEmp",list);
	}
	
}
