package jwd.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import jwd.model.Category;
import jwd.web.dto.CategoryDTO;

@Component
public class CategoryToCategoryDTO implements Converter<Category,CategoryDTO> {
  @Override
  public CategoryDTO convert(Category category) {

    CategoryDTO categoryDTO = new CategoryDTO();

    categoryDTO.setId(category.getId());
    categoryDTO.setName(category.getName());
    categoryDTO.setDescription(category.getDescription());

    return categoryDTO;
  }

  public List<CategoryDTO> convert(List<Category> categories){
    List<CategoryDTO> categoryDTOS = new ArrayList<>();
    for (Category c : categories){
      categoryDTOS.add(convert(c));
    }

    return categoryDTOS;
  }
}
