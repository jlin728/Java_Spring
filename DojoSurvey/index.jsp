<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
        <title>Survey</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/app.js"></script>
</head>


<h1>Submitted Information</h1>

<form method="POST" action="/login">
    <label>First name: <input type="text" name="first"></label><br>
    <label>Last name: <input type="text" name="last"></label><br>
    <label>Dojo Location: <input type="text" name="location"></label><br>
    <label>Favorite Language: <input type="text" name="lang"></label><br>
    <label>Comment: <input type="text" name="comment"></label><br>
    <button>Submit</button>
</form>
