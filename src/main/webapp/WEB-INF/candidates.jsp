<%@ page language="java" import="java.sql.*"%>

<html>
<head></head>
<body>

        <h1>This is a User Page</h1>

        <%
            String candidate = (String) session.getAttribute("username");
            out.print("Welcome " + candidate);
        %>

</body>
</html>