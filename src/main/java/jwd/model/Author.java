package jwd.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
  private List<Ad> ads;

  public List<Ad> getAds() {
    return ads;
  }

  public void addAd(Ad ad) {
    this.ads.add(ad);
    if(ad.getAuthor()!=this){
      ad.setAuthor(this);
    }
  }

  public void removeAd(Ad ad){
    ad.setCategory(null);
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
}
