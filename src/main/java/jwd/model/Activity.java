package jwd.model;

/**
 * Created by Dusan on 5/23/2017.
 */
public class Activity {

  private Long id;
  private String name;

  public Activity(Long id, String name) {
    this.id = id;
    this.name = name;
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
