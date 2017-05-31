package jwd.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by Dusan on 5/24/2017.
 */
@Entity
public class User {

  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String email;
  @Column
  private String password;
  @Column
  private String firstName;
  @Column
  private String lastName;
  @Column
  private String adminComment;
  @OneToMany(mappedBy = "user",cascade= CascadeType.REMOVE)
  List<Address> addresses = new ArrayList<>();;

  public User() {
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public void addAddress(Address address) {
    this.addresses.add(address);
    if(address.getUser()!=this){
      address.setUser(this);
    }

  }
  public void removeAddress(Address address){
    address.setUser(null);
    addresses.remove(address);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAdminComment() {
    return adminComment;
  }

  public void setAdminComment(String adminComment) {
    this.adminComment = adminComment;
  }
}
