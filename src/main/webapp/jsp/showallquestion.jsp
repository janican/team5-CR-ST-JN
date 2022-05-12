<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Candidates" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All candidates</title>
</head>
<body>


<table>
<tr>
	<th>Ehdokas_ID</th>
	<th>Sukunimi</th>
	
</tr>
<c:forEach var="question" items="${requestScope.kysymyslista }">
	<tr>
		<td>${question.kysymysId }</td>
		<td>${question.kysymys }</td>
		
	</tr>
</c:forEach>
</table>

</body>
</html>