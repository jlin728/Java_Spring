<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Product</title>
</head>

<body>
<h1>${ product.name }</h1>

	<h2>All Categories This Product Belongs To:</h2>

	<c:forEach items = "${ product.categories }" var = "cat">
		<p>${ cat.name }</p>
	</c:forEach>
	
	<form method = "POST" action = "/products/${ product.id }/join" >
		<select name = "cat_id">
			<c:forEach items = "${categories}" var = "category">
				<option value = "${category.id}"> ${category.name} </option>
			</c:forEach>
		</select>
		<input type = "submit" value = "Add">
	
	</form>



</body>
</html>