package jwd.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String description;
  @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
  private List<Ad> ads = new ArrayList<>();

  public List<Ad> getAds() {
    return ads;
  }

  public void addAds(Ad ad) {
    this.ads.add(ad);
    if (ad.getCategory()!= this){
      ad.setCategory(this);
    }
  }

  public void removeAd(Ad ad){
//    address.setUser(null);
    this.ads.remove(ad);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
