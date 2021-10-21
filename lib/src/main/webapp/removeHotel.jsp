<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>
<html>
<head>
<title>Remove hotel</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 ,td,tr{font-family: "Raleway", sans-serif}

body, html {
  height: 100%;
  line-height: 1.8;
}
</style>
<s:head/>
</head>
<body  >

<s:actionerror/>
	<div align="center">
		<label align="center">
			<h3>remove hotel</h3>
		</label>

		<s:form action="removeHotel">

			<s:textfield name="hotelName" label="Hotel-Name" />
              <s:textfield name="hotelRegNo" label="Hotel-Registration-Number"/>
			
		
			<s:submit value="Remove Hotel" />
			
		</s:form>
	</div>
</body>
</html>