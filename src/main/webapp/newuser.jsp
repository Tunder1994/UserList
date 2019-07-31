<%--
  Created by IntelliJ IDEA.
  User: Dawid
  Date: 31.07.2019
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Dodajesz nowego usera do bazy</h1>

<form action="/newuser" method="post">
    <table>
        <tr>
            <td>Nazwa:</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><input type="text" name="email"></td>
                <% if(Boolean.parseBoolean(request.getParameter("invalidemail"))){ %>
            <td><font color="red">Podałeś błędny mail</font></td>
                <%}%>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <td>Hasło:</td>
            <td><input type="password" name="password1"></td>
            <% if(Boolean.parseBoolean(request.getParameter("wrongpassword"))){ %>
            <td><font color="red">Podałes błędne hasło: musi być 8 znaków, jedna duża, jedna mała litera oraz cyfra</font></td>
            <%}%>
        </tr>
        <tr>
            <td>Powtórz hasło:</td>
            <td><input type="password" name="password2"></td>
            <% if(Boolean.parseBoolean(request.getParameter("invalidpasswords"))){ %>
            <td><font color="red">Hasła muszą być takie same</font></td>
            <%}%>
        </tr>
    </table>
    <input type="submit" value="Wyślij">
</form>


</body>
</html>
