<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<form:form method="POST" action="/books/edit/{id}" modelAttribute="book"> <!-- same template as addNew book, only changed the action to /edit{id} -->
    <form:label path="title">Title				<!-- allows for in form validation -->
    <form:input path="title"/>
    <form:errors path="title"/>	
    </form:label><br>
    
    <form:label path="description">Description
    <form:textarea path="description"/>
    <form:errors path="description"/>
    </form:label><br>
    
    <form:label path="language">language
    <form:input path="language"/>
    <form:errors path="language"/>
	</form:label><br>
    
    <form:label path="numberOfPages">Pages
    <form:input type="numbers"	path="numberOfPages"/>
    <form:errors path="numberOfPages"/>
    </form:label><br>
    
    <input type="submit" value="Submit"/>
</form:form>