package jwd.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import jwd.model.Ad;
import jwd.model.Category;
import jwd.service.AdService;
import jwd.web.dto.AdDTO;
import jwd.web.dto.CategoryDTO;

@Component
public class AdDTOToAd implements Converter<AdDTO,Ad> {

  @Autowired
  AdService adService;

  @Override
  public Ad convert(AdDTO adDTO) {

    Ad ad = new Ad();

    if (adDTO.getId()!=null){
      ad = adService.findAd(adDTO.getId());

      if (ad==null){
        throw new IllegalStateException("Tried to modify a non-existant category");
      }
    }

    ad.setId(adDTO.getId());
    ad.getCategory().setName(adDTO.getCategoryName());
    ad.getAuthor().setName(adDTO.getAuthorName());
    ad.setPostedDate(adDTO.getPostedDate());
    ad.setExpiryDate(adDTO.getExpiryDate());
    ad.setName(adDTO.getAdName());

    return ad;
  }

  public List<Ad> convert(List<AdDTO> adDTOS){
    List<Ad> ads= new ArrayList<>();
    for (AdDTO dto : adDTOS){
      ads.add(convert(dto));
    }

    return ads;
  }
}
