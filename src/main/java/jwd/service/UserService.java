package jwd.service;

import org.springframework.data.domain.Page;

import java.util.List;
import jwd.model.User;

/**
 * Created by Dusan on 5/24/2017.
 */
public interface UserService {

  User findOne(Long id);
  Page<User> findAll(String smer);
  User save(User user);
  void delete(Long id);

  User findByFirstName(String name);
  User findByLastName(String name);
  User findByEmail(String name);
}
