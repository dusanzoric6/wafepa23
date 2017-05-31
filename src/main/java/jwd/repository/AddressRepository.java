package jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import jwd.model.Address;
import jwd.model.User;

/**
 * Created by Dusan on 5/25/2017.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

  List<Address> findByUser(User user);

  List<Address> findByUserId(Long userId);

  Address findByIdAndUserId(Long id, Long userId);
}
