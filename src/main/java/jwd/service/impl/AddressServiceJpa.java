package jwd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import jwd.model.Address;
import jwd.model.User;
import jwd.repository.AddressRepository;
import jwd.service.AddressService;

/**
 * Created by Dusan on 5/25/2017.
 */
@Service
public class AddressServiceJpa implements AddressService {
  @Autowired
  private AddressRepository addressRepository;

  @Override
  public Address findOne(Long id) {

    return addressRepository.findOne(id);
  }

  @Override
  public List<Address> findAll() {

    return addressRepository.findAll();
  }

  @Override
  public Address save(Address address) {

    return addressRepository.save(address);
  }

  @Override
  public void delete(Long id) {
    addressRepository.delete(id);
  }

  @Override
  public List<Address> findByUser(User user) {
    return addressRepository.findByUser(user);
  }

  @Override
  public Address findByIdAndUser(Long id, Long userId) {

    return addressRepository.findByIdAndUserId(id, userId);
  }

  @Override
  public List<Address> findByUserId(Long userId) {

    return addressRepository.findByUserId(userId);
  }
}
