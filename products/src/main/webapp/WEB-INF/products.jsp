<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Prod</title>
</head>
<body>
<h1>New Product:</h1>
<form:form action = "/products/new" method = "POST" modelAttribute = "product">
	<form:label path = "name" > Name:
		<form:input type = "text" path = "name"></form:input>
		<form:errors path = "name"></form:errors>
	</form:label>
	<br>
	<form:label path = "desc" > Description:
		<form:input type = "text" path = "desc"></form:input>
		<form:errors path = "desc"></form:errors>
	</form:label>
	<br>
	<form:label path = "price" > Price:
		<form:input type = "number" path = "price"></form:input>
		<form:errors path = "price"></form:errors>
	</form:label>
	<br>
	<input type = "submit" value = "Create Product">
</form:form>
 
</body>
</html>