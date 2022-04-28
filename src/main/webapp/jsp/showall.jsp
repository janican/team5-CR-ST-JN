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

<a href="jsp/addcandidates.jsp" class="button">Add new candidate</a>

<table>
<tr>
	<th>Ehdokas_ID</th>
	<th>Sukunimi</th>
	<th>Etunimi</th>
	<th>Puolue</th>
	<th>Kotipaikkakunta</th>
	<th>Ika</th>
	<th>Miksi_eduskuntaan</th>
	<th>Mita_asioita_haluat_edistaa</th>
	<th>Ammatti</th>
</tr>
<c:forEach var="candidates" items="${sessionScope.allcandidates }">
	<tr>
		<td>${candidates.id }</td>
		<td>${candidates.sukunimi }</td>
		<td>${candidates.etunimi }</td>
		<td>${candidates.puolue}</td>
		<td>${candidates.kotipaikkakunta }</td>
		<td>${candidates.ika }</td>
		<td>${candidates.miksi_eduskuntaan}</td>
		<td>${candidates.mita_asioita_haluat_edistaa}</td>
		<td>${candidates.ammatti}</td>
		<td>
			<a href="/editcandidates?id=${candidates.id }">Edit</a>
			<a href="/deletecandidates?id=${candidates.id }">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>