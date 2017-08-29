<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
        <h1>Add New Employee</h1>  
       <form:form method="post" action="addEmp">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="empName"  /></td>  
         </tr>    
         <tr>    
          <td>Salary :</td>    
          <td><form:input path="empSalary" /></td>  
         </tr>   
         <tr>    
          <td>Designation :</td>    
          <td><form:input path="empDesignation" /></td>  
         </tr> 
         <tr>    
          <td>Department :</td>    
          <td><form:input path="empDepartment" /></td>  
         </tr>  
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
</form:form>   