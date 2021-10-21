<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
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
 <label align="center" > <h3> login </h3> </label>
  
  <s:form  action="login">
  <s:textfield label ="Registered PhoneNO." name="mobile"/>

  <s:password label ="enter password" name = "password" />
 <s:submit value="login" />
 </s:form >
 <div>New User? <a href="registerForm.jsp">please Register first</a></div>
 </div>
</body>
</html>