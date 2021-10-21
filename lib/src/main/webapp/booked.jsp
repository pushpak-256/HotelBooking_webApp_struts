<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<% String mob = (String)session.getAttribute("mobile");

	%>
<br> <s:property value="url"/> <br>
<s:property value="mobile"/>
<br> <s:property value="city" />
<%=mob %>
<body>
</body>
</html>