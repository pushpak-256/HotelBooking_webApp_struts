<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search hotels</title>
</head>
<body>
<head>
<title>Search hotel</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6, td, tr {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%;
	line-height: 1.8;
}
</style>
<s:head />
</head>

<div align="center">

	<p>
	<h4>Search for ideal hotel</h4>
	<h6>Enter what exactly you want</h6>
	</p>

	<s:form action="searchHotels">

		<s:radio list="{'Mumbai','Pune','Thane','Goa'}" name="city"
			multiple="true" label="select City" />

		<s:radio label="wifi" list="{'unavailable','available'}" name="wifi"
			multiple="true" />

		<s:checkboxlist multiple="false" list="{'breakfast','lunch','dinner'}"
			label="food" name="food" />
		<s:radio multiple="false"
			list="{'>0','<1000',' BETWEEN 1000 AND 3000','>3000'}"
			label="Price range" name="price" />
		<s:radio multiple="false" list="{'available','show-all'}"
			label="Availablity of Rooms" name="rooms" />
		<%
			String mob = request.getParameter("mobile");
			session.setAttribute("mobile", mob);
	
	
		%>
		<s:submit value="Apply-Filter"></s:submit>
	</s:form>
</div>

</body>

</html>