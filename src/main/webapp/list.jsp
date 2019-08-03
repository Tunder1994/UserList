
<%@ page import="java.util.List" %>
<%@ page import="pl.dros.sda.userlist.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Użytkownicy</title>
    <style>
        table{
            width: 95%;
        }
        table, td, th {
            border: black solid 1px;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h1>Użytkownicy</h1>
<table>
    <tr>
        <th>L.p.</th>
        <th>Login</th>
        <th>Nazwa</th>
        <th>E-mail</th>
    </tr>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
    %>
    <tr>
        <td><%=i+1%></td>
        <td><%=user.getLogin()%></td>
        <td><%=user.getUserName()%></td>
        <td><%=user.getEMail()%></td>
    </tr>
    <%
        }
    %>
</table>
<a href="newuser"><button>Nowy użytkownik</button></a>
</body>
</html>
