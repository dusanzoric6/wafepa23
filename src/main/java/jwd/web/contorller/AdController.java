package jwd.web.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import jwd.model.Ad;
import jwd.model.Category;
import jwd.service.AdService;
import jwd.service.CategoryService;
import jwd.support.AdToAdDTO;
import jwd.support.CategoryToCategoryDTO;
import jwd.web.dto.AdDTO;
import jwd.web.dto.CategoryDTO;

@RestController
@RequestMapping(value = "/ads")
public class AdController {

  @Autowired
  AdService adService;
  @Autowired
  AdToAdDTO adToAdDTO;

  @RequestMapping(method = RequestMethod.GET)
  ResponseEntity<List<AdDTO>> getAds(
//      @RequestParam(value = "directionCat", defaultValue = "ASC", required = false )String directionCat,
//      @RequestParam (value = "sortCat", defaultValue = "id", required = false )String sortCat
  ){

//    Page<Category> categoriesPage = categoryService.findAll(sortCat,directionCat);
    List<Ad> ads;

    ads= adService.findAll();
    return new ResponseEntity<>(adToAdDTO.convert(ads), HttpStatus.OK);
  }
}
