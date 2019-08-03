package pl.dros.sda.userlist.servlet;

import pl.dros.sda.userlist.model.User;
import pl.dros.sda.userlist.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/list")
public class ListServlet extends HttpServlet {

  private UserRepository repository = UserRepository.INSTANCE;

  @Override
  public void init() throws ServletException {
    repository.save(
        User.builder()
            .userName("user1")
            .eMail("user1@mail.com")
            .login("login1")
            .password("password")
            .build());
    repository.save(
        User.builder()
            .userName("user2")
            .eMail("user2@mail.com")
            .login("login2")
            .password("password")
            .build());
    repository.save(
        User.builder()
            .userName("user3")
            .eMail("user3@mail.com")
            .login("login3")
            .password("password")
            .build());
    repository.save(
        User.builder()
            .userName("user4")
            .eMail("user4@mail.com")
            .login("login4")
            .password("password")
            .build());
    repository.save(
        User.builder()
            .userName("user5")
            .eMail("user5@mail.com")
            .login("login5")
            .password("password")
            .build());
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<User> allUsers = repository.findAll();

    resp.setHeader("Content-Type", "text/html; charset=utf-8");
    PrintWriter writer = resp.getWriter();

    writer
        .append("<html>")
        .append("<head>")
        .append("<title>List</title>")
        .append("<meta charset=\"UTF-8\"/>")
        .append("<style>")
        .append("tr.done{text-decoration: line-through}")
        .append("</style>")
        .append("</head>")
        .append("<body>")
        .append("<h1> Userzy </h1>")
        .append("<table border=1>")
        .append("<tr>")
        .append("<td>L.p.</td>")
        .append("<td>User</td>")
        .append("<td>E-mail</td>")
        .append("<td>Login</td>")
        .append("</tr>");
    for (User user : allUsers) {
      writer
          .append("<tr>")
          .append("<td>" + user.getId() + "</td>")
          .append("<td>" + user.getUserName() + "</td>")
          .append("<td>" + user.getEMail() + "</td>")
          .append("<td>" + user.getLogin() + "</td>")
          .append("</tr>");
    }
    writer.append("</table>");
    writer.append("<br><br>");
    writer.append(
        "<a href=\"http://localhost:9070/newuser\"><input type=\"submit\" value = \"Nowy User\"></a>");
    writer.append("</body>");

    writer.append("</html>");
  }
}
