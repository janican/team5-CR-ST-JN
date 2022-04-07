<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Candidates" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Candidates</title>
</head>
<body>

	<form action='./editcandidates' method='post'>
		Sukunimi: <input type='text' name='sukunimi' value='${sessionScope.candidates.sukunimi }'><br>
		Etunimi: <input type='text' name='etunimi' value='${sessionScope.candidates.etunimi }'><br>
		<input type="hidden" name="id" value="${sessionScope.candidates.id }">		
		<input type='submit' name='ok' value='Edit'>
	</form>
	
</body>
</html>