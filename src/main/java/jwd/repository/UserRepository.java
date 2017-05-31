package jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.model.User;

/**
 * Created by Dusan on 5/25/2017.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {

  User findByFirstName(String firstName);
  User findByLastName(String lastName);
  User findByEmail(String email);
}
