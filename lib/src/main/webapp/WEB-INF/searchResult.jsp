<%@page import="java.sql.*"%>
<%@page import="DBservices.DbConnector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Select hotel</title>
</head>
<body>
<head>
<title>Select a Hotels</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<s:head />
</head>



<body>

	<%
	String mob = (String) session.getAttribute("mobile");
	session.setAttribute("mobile", mob);
	%>


	<div class="w3-container">
		<h2>Recommended hotels for You</h2>


		<table class="w3-table-all">
			<thead>
				<tr class="w3-light-red w3-hover-grey">
					<th>Name</th>
					<th>city</th>
					<th>price</th>
					<th>lunch</th>
					<th>dinner</th>
					<th>breakfast</th>
					<th>Available rooms</th>
					<th></th>
				</tr>
			</thead>


			<s:iterator value="hotelsFound" >
				<tr class="w3-light-red w3-hover-gainsboro">

					<td><s:property value="name" /></td>
					<td><s:property value="city" /></td>
					<td><s:property value="pricee" /></td>
					<td><s:property value="lunch" /></td>
					<td><s:property value="dinner" /></td>
					<td><s:property value="breakfast" /></td>
					<td><s:property value="rooms" /></td>
				<td>
					
					
		
	
		
	            	</td> 
	         	<td>
					<s:form
						action="book">
<!-- random links for each hotel record -->
						<s:hidden name="url" value="%{ #session['mobile'] },%{name},%{city}" /> 
				
						<s:submit value="Book" class="w3-hover-black"/>
					</s:form>
					
					</td> 

				</tr>
			</s:iterator>

		</table>
	</div>
	      
</body>
</html>
