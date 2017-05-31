package jwd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Dusan on 5/25/2017.
 */
@Entity
public class Address {

  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String streat;
  @Column
  private String number;

  @ManyToOne(fetch= FetchType.EAGER)
  private User user;

  public Address() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreat() {
    return streat;
  }

  public void setStreat(String streat) {
    this.streat = streat;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
    if(user!=null && !user.getAddresses().contains(this)){
      user.getAddresses().add(this);
    }

  }
}
