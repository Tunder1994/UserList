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
            <td><span style="color: red; "> ${invalidMail}</span></td>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <td>Hasło:</td>
            <td><input type="password" name="password1"></td>
            <td><span style="color: red; "> ${invalidPassword}</span></td>

        </tr>
        <tr>
            <td>Powtórz hasło:</td>
            <td><input type="password" name="password2"></td>
            <td><span style="color: red; "> ${errorPassword}</span></td>
        </tr>
    </table>
    <input type="submit" value="Wyślij">
</form>


</body>
</html>
