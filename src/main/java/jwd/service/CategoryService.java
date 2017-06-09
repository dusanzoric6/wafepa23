package jwd.service;


import org.springframework.data.domain.Page;

import jwd.model.Category;

public interface CategoryService {

  Category findCategory(Long id);
  Page<Category> findAll(String sortCat, String directionCat);
  Category save(Category category);
  void delete(Long id);
}
