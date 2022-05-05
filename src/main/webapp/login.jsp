<%--
  Created by IntelliJ IDEA.
  User: NEETA
  Date: 05-05-2022
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <script src="login.js"></script>
</head>
<body>
<form action="LoginServlet" method="post" autocomplete="off">
    UserName:<input type="text" id="name" name="user" autocomplete="new-password" required/>
    <error-output class="text-error" for="text"></error-output>
    <br>
    Password:<input type="password" id="pwd" name="pwd" autocomplete="new-password" required/>
    <br>
    <input type="submit" value="Login" />
</form>
</body>
</html>
