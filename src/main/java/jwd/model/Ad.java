package jwd.model;

import java.sql.Date;
import javax.persistence.*;

@Entity
public class Ad {
  @Id
  @GeneratedValue
  private Long id;
  @ManyToOne(fetch = FetchType.EAGER)
  private Category category;
  private String name;
  @Lob
  private String text;
  private Date postedDate;
  private Date expiryDate;
  @ManyToOne(fetch = FetchType.EAGER)
  private Author author;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
    if (category!=null && !category.getAds().contains(this)){
      category.addAds(this);
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(Date postedDate) {
    this.postedDate = postedDate;
  }

  public Date getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(Date expiryDate) {
    this.expiryDate = expiryDate;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
    if (author!=null && !author.getAds().contains(this)){
      author.addAd(this);
    }
  }
}
