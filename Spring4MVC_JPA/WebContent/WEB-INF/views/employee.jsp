<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Employee Management</title>
	<style>
	.error 
	{
		color: #ff0000;
		font-weight: bold;
	}
	#listOfEmployees tr:first-child{
		font-weight: bold;
	}
	</style>
</head>

<script type="text/javascript">
function detate()
{
 var x = confirm("Are you sure you want to delete?");
 if (x)
 return true;
 else
 return false;
 }
function update()
{
 var x = confirm("Are you sure you want to update?");
 if (x)
 return true;
 else
 return false;
 }
</script>


   <body>
	
	<h2><spring:message code="lbl.page.list" text="lbl.page.list" /></h2>
	<br/>
	
	<td><a href="addBankDetails.htm">Add Bank Details</a></td>
	
	

	<h2><spring:message code="lbl.page" text="Add New Employee" /></h2>
	<br/>
	<form:form method="post" modelAttribute="employee" action="addemployee.htm">
		<table>
		        <form:hidden path="id" value="${employee.id}" ></form:hidden>
			<tr>
				<td><spring:message code="lbl.firstName" text="First Name" /></td>
				<td><form:input path="firstname" /></td>
				<td><form:errors path="firstname" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="lbl.lastName" text="Last Name" /></td>
				<td><form:input path="lastname" /></td>
				<td><form:errors path="lastname" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="lbl.email" text="Email Id" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td colspan="3"><input type="submit" value="Add Employee"/></td>
			</tr>
		</table>
	</form:form>
	
	
	
	
	<table id="listOfEmployees" border="1">
	<tr>
	    <td>S.NO</td>
	    <td>First Name</td>
	    <td>Last Name</td>
	    <td>Email</td>
	    <td>Update</td>
	    <td>Delete</td>
	  </tr>
	<c:forEach items="${allEmployees}" var="employee" varStatus="count">    
	  <tr>
	    <td>${count.count}</td>
	    <td>${employee.firstname}</td>
	    <td>${employee.lastname}</td>
	    <td>${employee.email}</td>
	    <td><a href="editEmployee.htm?id=<c:out value='${employee.id}'/>" onclick="return update();">Update </a></td>
	    <td><a href="deleteEmployee.htm?id=<c:out value='${employee.id}'/>" onclick="return detate();">Delete</a> </td>
	   
	  </tr>
	</c:forEach>
	</table>
	
	
	
	
</body>
</html>