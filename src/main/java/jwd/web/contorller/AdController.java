package jwd.web.contorller;

import jwd.model.User;
import jwd.support.AdNewDTOToAd;
import jwd.support.AdToAdDetailsDTO;
import jwd.support.AdToAdNewDTO;
import jwd.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import jwd.model.Ad;
import jwd.service.AdService;
import jwd.support.AdToAdDTO;

@RestController
@RequestMapping(value = "/ads")
public class AdController {

  @Autowired
  AdService adService;

  @Autowired
  AdToAdDTO adToAdDTO;

  @Autowired
  AdToAdDetailsDTO adToAdDetailsDTO;

  @Autowired
  AdNewDTOToAd adNewDTOToAd;

  @Autowired
  AdToAdNewDTO adToAdNewDTO;

  @RequestMapping(method = RequestMethod.GET)
  ResponseEntity<List<AdDTO>> getAds(
      @RequestParam(value = "expiryDateFilter", required = false )String expiryDateFilter,
      @RequestParam(value = "nameSearch", required = false )String nameSearch,
      @RequestParam (value = "sortAd", defaultValue = "id", required = false )String sortAd,
      @RequestParam (value = "directionAd", defaultValue = "ASC", required = false )String directionAd
  ){
    List<Ad> ads = null;
    Page<Ad> adsPage = null;
    if(expiryDateFilter!=null){
      try {
//        from String param to Date.sql
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(expiryDateFilter);
        Date convertedDate = new Date(utilDate.getTime());

        adsPage = adService.findByExpiryDateAfter(convertedDate);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    else if(nameSearch != null){
      adsPage = adService.findByName(nameSearch);
    }
    else {
      adsPage = adService.findAll(sortAd, directionAd);
    }
    ads = adsPage.getContent();
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

  @RequestMapping(method=RequestMethod.POST, consumes="application/json")
  public ResponseEntity<AdNewDTO> add0(@RequestBody AdNewDTO ad){
    if(ad==null){
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Ad savedAd = adService.save(adNewDTOToAd.convert(ad));

    return new ResponseEntity<>(adToAdNewDTO.convert(savedAd),
            HttpStatus.CREATED);
  }
}
