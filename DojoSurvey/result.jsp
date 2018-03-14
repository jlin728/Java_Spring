<%@ page session="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
        <title>Survey Results</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/app.js"></script>
</head>

<p>Submitted Information</p>
<p>Name: ${sessionScope.first} ${sessionScope.last} </p>
<p>Dojo Location: ${sessionScope.location} </p>
<p>Favorite Language: ${sessionScope.lang} </p>
<p>Comment: ${sessionScope.comment} </p>

<p><a href="/">Home</a> </p>
