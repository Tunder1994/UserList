package pl.dros.sda.userlist.repository;

import pl.dros.sda.userlist.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum UserRepository {
  INSTANCE;

  private Map<Integer, User> data = new HashMap<>();
  private Integer lastInsertedId = 0;

  public User findById(Integer id) {
    return data.get(id);
  }

  public List<User> findAll() {
    return new ArrayList<>(data.values());
  }

  public User save(User user) {
    if (user.getId() == null) {
      user.setId(++lastInsertedId);
    }
    data.put(user.getId(), user);
    return user;
  }
}
