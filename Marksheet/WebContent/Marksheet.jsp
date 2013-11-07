<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Marksheet.jsp' starting page</title>
    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form action="marksheet" method="post">
  
   <table align="center">
   <tr><th bgcolor="cream" colspan="2" >Markhseet Records </th></tr>

   <tr bgcolor="lightblue"><td><label>Name</label></td><td><input type="text" name="patrika"/></td></tr>
   <tr bgcolor="lightblue"><td><label>Roll No.</label></td><td><input type="text" name="rollno"/></td></tr>
   <tr bgcolor="lightblue"><td><label>Marks</label></td><td><input type="text" name="marks"/></td></tr>
   <tr bgcolor="lightblue"><td><label>Physics</label></td><td><input type="text" name="phy"/></td></tr>
   <tr bgcolor="lightblue"><td><label>Chemistry</label></td><td><input type="text" name="chem"/></td></tr>
   <tr bgcolor="lightblue"><td><label>Math</label></td><td><input type="text" name="math"/></td></tr>
   
   
   <tr><td><input type="submit" value="Add" name=operation/></td><td><input type="submit" value="Update" name="operation"/></td>
   </tr><tr><td><input type="submit" value="delete" name="operation"/></td><td><input type="submit" value="Get List" name="operation"></td></tr>
   
   </table>
   <div><%= request.getAttribute("marksheet entered".toString()) %></div>
	   
   </form>
  </body>
</html>
