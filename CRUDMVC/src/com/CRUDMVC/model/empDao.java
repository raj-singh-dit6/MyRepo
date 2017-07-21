package com.CRUDMVC.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class empDao {
	
	JdbcTemplate template;
	private String lQuery="";
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int addEmployee(Employee emp){
		
		System.out.println(emp.getEmpName());
		System.out.println(emp.getEmpDepartment());
		System.out.println(emp.getEmpDesignation());
		System.out.println(emp.getEmpSalary());
		
		lQuery="Insert into employee(empName,empDepartment,empDesignation,empSalary) values('"+emp.getEmpName()+"','"+emp.getEmpDepartment()+"','"+emp.getEmpDesignation()+"',"+emp.getEmpSalary() +")";		
		System.out.println(lQuery);
		return template.update(lQuery);  
	}
	
	public int editEmployee(Employee emp){
		lQuery="Update employee set empName="+emp.getEmpName()+ " empDepartment="+emp.getEmpDepartment()+",empDesignation="+emp.getEmpDesignation() +",empSalary"+emp.getEmpSalary()+")";
		return template.update(lQuery);		
	}
	
	
	public int deleteEmployee(int id){
		lQuery="Delete from employee where empID="+id; 
		return template.update(lQuery);		
	}
	
	public Employee getEmployeeDetailsByID(int id)
	{
		lQuery="select * from employee where empID=?"; 
		return template.queryForObject(lQuery,new Object[]{id}, new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public List<Employee> getAllEmployeeDetails()
	{
		lQuery="select * from employee"; 
		return template.query(lQuery, new RowMapper<Employee>(){
				public Employee mapRow(ResultSet rs,int row) throws SQLException {
					 Employee e=new Employee();
					 e.setEmpName(rs.getString(1));
					 e.setEmpDepartment(rs.getString(2));
					 e.setEmpDesignation(rs.getString(3));
					 e.setEmpSalary(rs.getInt(4));
					 return e;
				}
		  });  
	}
}  
