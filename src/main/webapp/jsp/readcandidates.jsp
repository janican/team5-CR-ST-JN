<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Candidates" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Candidates</title>
</head>
<body>

	<form action='/showall.jsp' method='post'>
		Sukunimi: <input type='text' name='sukunimi' value=''><br>
		Etunimi: <input type='text' name='etunimi' value=''><br>
		Puolue: <input type='text' name='puolue' value=''><br>
		Kotipaikkakunta: <input type='text' name='kotipaikkakunta' value=''><br>
		Ika: <input type='text' name='ika' value=''><br>
		Miksi_eduskuntaan: <input type='text' name='miksi_eduskuntaan' value=''><br>
		Mita_asioita_haluat_edistaa: <input type='text' name='mita_asioita_haluat_edistaa' value=''><br>
		Ammatti: <input type='text' name='ammatti' value=''><br>
		<input type='submit' name='ok' value='Add'>
	</form>
	
</body>
</html>