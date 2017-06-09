package jwd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import jwd.model.Category;
import jwd.repository.CategoryRepository;
import jwd.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  CategoryRepository categoryRepository;

  @Override
  public Category findCategory(Long id) {
    return categoryRepository.findOne(id);
  }

  @Override
  public Page<Category> findAll(String sortCat, String directionCat) {

    return categoryRepository.findAll(new PageRequest(0,5, Sort.Direction.fromString(directionCat), sortCat));
  }

  @Override
  public Category save(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  public void delete(Long id) {
    categoryRepository.delete(id);

  }
}
