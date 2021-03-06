package jwd.web.dto;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class CategoryDTO {

  private Long id;
  @NotBlank(message="Name must not be empty")
  @Size(max=30)
  private String name;
  private String description;

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
