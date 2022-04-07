<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Admin Page</title>
</head>
<body>

        <h1>This is an Admin Page</h1>

        <%
            String admin = (String) session.getAttribute("username");
            out.print("Welcome " + admin);
        %>     

</body>   
</html>