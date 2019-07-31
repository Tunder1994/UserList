package pl.dros.sda.userlist.servlet;

import pl.dros.sda.userlist.model.User;
import pl.dros.sda.userlist.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/newuser")
public class NewUserServlet extends HttpServlet {
  static final String EMAILREGEX =
      "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
  static final String PASSREGEX = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
  private UserRepository repository = UserRepository.INSTANCE;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    String userName = req.getParameter("userName");
    String email = req.getParameter("email");
    String login = req.getParameter("login");
    String password1 = req.getParameter("password1");
    String password2 = req.getParameter("password2");
    String error = "/newuser.jsp?";
    int count = 0;

    if (!email.matches(EMAILREGEX)) {
      error += "invalidemail=true";
      count++;
    }
    if (!password1.matches(PASSREGEX)) {
      if (count > 0) {
        error += "&";
      }
      error += "wrongpassword=true";
      count++;
    }
    if (!password1.equals(password2)) {
      if (count > 0) {
        error += "&";
      }
      error += "invalidpasswords=true";
      count++;
    }
    if (count > 0) {
      resp.sendRedirect(error);
    } else {
      repository.save(
          User.builder().userName(userName).eMail(email).login(login).password(password1).build());
      resp.sendRedirect("/list");
    }
  }
}
