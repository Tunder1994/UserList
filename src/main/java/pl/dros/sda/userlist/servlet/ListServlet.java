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
      req.setAttribute("users", repository.findAll());
      req.getRequestDispatcher("/list.jsp")
              .forward(req, resp);
  }
}
