package jwd.support;

import jwd.model.Ad;
import jwd.web.dto.AdDetailsDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdToAdDetailsDTO implements Converter<Ad,AdDetailsDTO> {

    @Override
    public AdDetailsDTO convert(Ad ad) {

        AdDetailsDTO adDetailsDTO = new AdDetailsDTO();
        adDetailsDTO.setId(ad.getId());
        adDetailsDTO.setAdName(ad.getName());
        adDetailsDTO.setAdText(ad.getText());
        adDetailsDTO.setAuthorName(ad.getAuthor().getName());
        adDetailsDTO.setAuthorEmail(ad.getAuthor().getEmail());
        adDetailsDTO.setAuthorPhone(ad.getAuthor().getPhone());
        adDetailsDTO.setExpiryDate(ad.getExpiryDate());
        adDetailsDTO.setPostedDate(ad.getPostedDate());

        return adDetailsDTO;
    }
}
