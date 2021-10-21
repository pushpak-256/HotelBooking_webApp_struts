<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>admin page</title>
<s:head />
</head>
<body>
 <div class="w3-container">
  <p align="center">hotel operation</p>
   <table class="w3-table-all">
  <tr class="w3-light-red w3-hover-grey">
    <th>add hotel</th>
    <th>remove hotel</th>
    
  </tr>
  <tr class="w3-light-red w3-hover-gainsboro">
    <td><a href="addHotel.jsp"> <button>add hotel</button> </a></td>
    <td><a href="removeHotel.jsp"> <button>remove hotel </button>  </a></td>
    
  </tr>
  
</table>
 </div>
</body>
</html>