package jwd.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import jwd.model.Category;
import jwd.service.CategoryService;
import jwd.web.dto.CategoryDTO;

@Component
public class CategoryDTOToCategory implements Converter<CategoryDTO,Category>{

  @Autowired
  CategoryService categoryService;

  @Override
  public Category convert(CategoryDTO categoryDTO) {
    Category category = new Category();

    if (categoryDTO.getId()!=null){
      category = categoryService.findCategory(categoryDTO.getId());

      if (category==null){
        throw new IllegalStateException("Tried to modify a non-existant category");
      }
    }

    category.setId(categoryDTO.getId());
    category.setName(categoryDTO.getName());
    category.setDescription(categoryDTO.getDescription());

    return category;
  }

  public List<Category> convert(List<CategoryDTO> categoryDTOS){
    List<Category> categories = new ArrayList<>();
    for (CategoryDTO dto : categoryDTOS){
      categories.add(convert(dto));
    }

    return categories;
  }
}
