<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>


<%@page import="java.util.ArrayList"%>

<html>
    <head>
        <title>Todos</title>
        <link rel="stylesheet" type="text/css" href="css/main.css"/>
          <meta charset="utf-8">
    </head>
    <body>
<%

//Dao dao = Dao.INSTANCE;

//UserService userService = UserServiceFactory.getUserService();
//User user = userService.getCurrentUser();

//String url = userService.createLoginURL(request.getRequestURI());
//String urlLinktext = "Login";
//List<Todo> todos = new ArrayList<Todo>();

//if (user != null){
//    url = userService.createLogoutURL(request.getRequestURI());
//    urlLinktext = "Logout";
//    todos = dao.getTodos(user.getUserId());
//}

%>
    <div style="width: 100%;">
        <div class="line"></div>
        <div class="topLine">
            <div style="float: left;"><img src="images/todo.png" /></div>
            <div style="float: left;" class="headline">Todos</div>
         
        </div>
    </div>

<div style="clear: both;"/>

<table>
  <tr>
      <th>Short description </th>
      <th>Long Description</th>
      <th>URL</th>
      <th>Done</th>
    </tr>
</table>


<hr />
<p><%= request.getAttribute("myname") %>.</p>

<div class="main">

<div class="headline">New todo</div>


<form action="/new" method="post" accept-charset="utf-8">
    <table>
        <tr>
            <td><label for="summary">Summary</label></td>
            <td><input type="text" name="summary" id="summary" size="65"/></td>
        </tr>
        <tr>
            <td valign="description"><label for="description">Description</label></td>
            <td><textarea rows="4" cols="50" name="description" id="description"></textarea></td>
        </tr>
    <tr>
        <td valign="top"><label for="url">URL</label></td>
        <td><input type="url" name="url" id="url" size="65" /></td>
    </tr>
    <tr>
            <td colspan="2" align="right"><input type="submit" value="Create"/></td>
        </tr>
    </table>
</form>


Please login with your Google account

</div>
</body>
</html>