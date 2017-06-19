package jwd.web.contorller;

import jwd.support.AdToAdDetailsDTO;
import jwd.web.dto.AdDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

  @Autowired
  AdToAdDetailsDTO adToAdDetailsDTO;

  @RequestMapping(method = RequestMethod.GET)
  ResponseEntity<List<AdDTO>> getAds(
      @RequestParam(value = "expiryDateFilter", required = false )String expiryDateFilter,
      @RequestParam(value = "nameSearch", required = false )String nameSearch,
      @RequestParam (value = "sortAd", defaultValue = "id", required = false )String sortAd,
      @RequestParam (value = "directionAd", defaultValue = "ASC", required = false )String directionAd
  ){

    Page<Ad> categoriesPage = adService.findAll(sortAd, directionAd);
    List<Ad> ads = null;
    if(expiryDateFilter!=null){
      try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(expiryDateFilter);
        Date convertedDate = new Date(utilDate.getTime());
        ads = adService.findByExpiryDateAfter(convertedDate);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    else if(nameSearch != null){
        ads = adService.findByName(nameSearch);
    }
    else {
      ads = categoriesPage.getContent();
    }
    return new ResponseEntity<>(adToAdDTO.convert(ads), HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  ResponseEntity<AdDetailsDTO> getAd(@PathVariable Long id) {
    Ad ad = adService.findAd(id);
    if (ad == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    AdDetailsDTO adDetailsDTO = adToAdDetailsDTO.convert(ad);

    return new ResponseEntity<>(adToAdDetailsDTO.convert(ad), HttpStatus.OK);
  }
}
