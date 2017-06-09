package jwd.web.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import jwd.model.Category;
import jwd.service.CategoryService;
import jwd.support.CategoryToCategoryDTO;
import jwd.web.dto.CategoryDTO;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

  @Autowired
  CategoryService categoryService;
  @Autowired
  CategoryToCategoryDTO toCategoryDTO;

  @RequestMapping(method = RequestMethod.GET)
  ResponseEntity<List<CategoryDTO>> getCategories(@RequestParam (value = "directionCat", defaultValue = "ASC", required = false )String directionCat,
                                                  @RequestParam (value = "sortCat", defaultValue = "id", required = false )String sortCat){

    Page<Category> categoriesPage = categoryService.findAll(sortCat,directionCat);
    List<Category> categoriesList= categoriesPage.getContent();
    return new ResponseEntity<>(toCategoryDTO.convert(categoriesList), HttpStatus.OK);
  }
}
