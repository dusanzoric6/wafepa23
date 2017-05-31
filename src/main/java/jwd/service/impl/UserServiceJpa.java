package jwd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import jwd.model.User;
import jwd.repository.UserRepository;
import jwd.service.UserService;

/**
 * Created by Dusan on 5/25/2017.
 */
@Service
public class UserServiceJpa  implements UserService{

  @Autowired
  UserRepository userRepository;

  @Override
  public User findOne(Long id) {
    return userRepository.findOne(id);
  }

  @Override
  public Page<User> findAll(String smer) {

    return (Page<User>) userRepository.findAll(new PageRequest(0, 10, Sort.Direction.fromString(smer), "lastName"));
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public void delete(Long id) {
    userRepository.delete(id);
  }

  @Override
  public User findByFirstName(String firstName) {
    return userRepository.findByFirstName(firstName);
  }

  @Override
  public User findByLastName(String lastName) {
    return userRepository.findByLastName(lastName);
  }

  @Override
  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

}
