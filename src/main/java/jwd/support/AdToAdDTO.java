package jwd.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import jwd.model.Ad;
import jwd.model.Address;
import jwd.web.dto.AdDTO;
import jwd.web.dto.AddressDTO;

@Component
public class AdToAdDTO implements Converter<Ad,AdDTO> {
  @Override
  public AdDTO convert(Ad ad) {

    AdDTO adDTO = new AdDTO();

    adDTO.setAdName(ad.getName());
//    adDTO.setAuthorName(ad.getAuthor().getName());
    adDTO.setCategoryName(ad.getCategory().getName());
    adDTO.setPostedDate(ad.getPostedDate());
    adDTO.setExpiryDate(ad.getExpiryDate());
    adDTO.setId(ad.getId());

    return adDTO;
  }

  public List<AdDTO> convert(List<Ad> ads){
    List<AdDTO> adDTOS = new ArrayList<>();

    for(Ad a : ads){
      adDTOS.add(convert(a));
    }

    return adDTOS;
  }
}
