<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Receipt</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<s:head />
</head>
<body>
<div class="w3-container">
		<h2>Booking Receipt</h2>


		<table class="w3-table-all">
			<thead>
				<tr class="w3-light-red w3-hover-grey">
					<th>Cust_Name</th>
					<th>Cust_MobileNo</th>
					<th>Hotel_Name</th>
				    <th>lunch</th>
				    <th>Dinner</th>
					<th>Breakfast</th>
					<th>WI-FI</th>
					<th>Rooms</th>
					<th>Total_Cost</th>
				
				</tr>
			</thead>


	
				<tr class="w3-light-red w3-hover-gainsboro">

					<td><s:property value="userName" /></td>
					<td><s:property value="mobile" /></td>
					<td><s:property value="hotelName" /></td>
					<td><s:property value="lunch" /></td>
					<td><s:property value="dinner" /></td>
					<td><s:property value="breakfast" /></td>
					<td> <s:property value="wifi"/> </td>
					<td> <s:property value="rooms"/> </td>
					
			      	<td><s:property value="price"/></td> 

				</tr>
		

		</table>
	</div>

</body>
</html>