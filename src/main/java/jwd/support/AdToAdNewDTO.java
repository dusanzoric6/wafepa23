package jwd.support;

import jwd.model.Ad;
import jwd.web.dto.AdNewDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdToAdNewDTO implements Converter<Ad,AdNewDTO>{


    @Override
    public AdNewDTO convert(Ad ad) {

        AdNewDTO adNewDTO = new AdNewDTO();
        adNewDTO.setId(ad.getId());
        adNewDTO.setAdName(ad.getName());
        adNewDTO.setAdText(ad.getText());
        adNewDTO.setPostedDate(ad.getPostedDate());
        adNewDTO.setExpiryDate(ad.getExpiryDate());
        adNewDTO.setCategoryId(ad.getCategory().getId());
//        adNewDTO.setAuthorName(ad.getAuthor().getName());

        return adNewDTO;
    }
}
