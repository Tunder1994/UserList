package pl.dros.sda.userlist.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class User {
  private Integer id;
  private String userName;
  private String eMail;
  private String login;
  @Getter(AccessLevel.PRIVATE)
  private String password;
}
