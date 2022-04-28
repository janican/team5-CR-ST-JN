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

	<form action='./editcandidate' method='post'>
		Sukunimi: <input type='text' name='sukunimi' value='${sessionScope.candidates.sukunimi }'><br>
		Etunimi: <input type='text' name='etunimi' value='${sessionScope.candidates.etunimi }'><br>
		Puolue: <input type='text' name='puolue' value='${sessionScope.candidates.puolue }'><br>
		Kotipaikkakunta: <input type='text' name='kotipaikkakunta' value='${sessionScope.candidates.kotipaikkakunta }'><br>
		Ika: <input type='text' name='ika' value='${sessionScope.candidates.ika }'><br>
		Miksi_eduskuntaan: <input type='text' name='miksi_eduskuntaan' value='${sessionScope.candidates.miksi_eduskuntaan }'><br>
		Mita_asioita_haluat_edistaa: <input type='text' name='mita_asioita_haluat_edistaa' value='${sessionScope.candidates.mita_asioita_haluat_edistaa }'><br>
		Ammatti: <input type='text' name='ammatti' value='${sessionScope.candidates.ammatti }'><br>
		<input type="hidden" name="id" value="${sessionScope.candidates.id }">
		<input type='submit' name='ok' value='Edit'>
	</form>
	
</body>
</html>