<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>Admin-Login</title>
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

<body>

<s:actionerror/>
<div align="center" >
 <label align="center" > <h3>Admin login </h3> </label>
  
  <s:form  action="loginAdmin">
  <s:textfield label ="Registered PhoneNO." name="mobile"/>

  <s:password label ="enter password" name = "password" />
  <s:radio list="{'Admin','no'}" name="admin"/>
 <s:submit value="login" />
 </s:form >
 <div>New Admin ? <a href="adminRegisterForm.jsp">please Register first</a></div>
 </div>
</body>
</html>