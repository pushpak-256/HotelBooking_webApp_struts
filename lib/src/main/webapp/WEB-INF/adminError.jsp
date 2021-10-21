<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>

<%-- <script>

function myFunction(){
	alert (' user already registered with that number' );
  }
  

</script> --%>



<title>Something went wrong</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 ,td,tr,a{font-family: "Raleway", sans-serif}

body, html {
  height: 100%;
  line-height: 1.8;
}
</style>
<s:head/>
</head>
<body onload = "myFunction()">
 
 <br>
 Following error occurred : <br>

     <p style="color:red;" > <s:property value ="error" /> </p>
	<div>
		<div>
		<p>for Users</p>
			<br> <a href="login.jsp">click here to login User</a> <br>
			<a href="registerForm.jsp">click here to Sign Up User </a>
		</div>
		<div>
		    <p>for Admins</p>
		    <br> <a href="adminPage.jsp">Go back to Admin section</a>
			<br> <a href="adminLogin.jsp">click here to Sign IN ADMIN</a> <br>
			<a href="adminRegisterForm.jsp">click here to Sign Up ADMIN </a>
		</div>
		
	</div>
</body>
</html>