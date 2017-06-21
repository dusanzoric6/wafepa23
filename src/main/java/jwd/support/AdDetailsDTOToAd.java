package jwd.support;

import jwd.model.Ad;
import jwd.model.Address;
import jwd.service.AdService;
import jwd.service.AuthorService;
import jwd.web.dto.AdDetailsDTO;
import jwd.web.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdDetailsDTOToAd implements Converter<AdDetailsDTO,Ad> {
    @Autowired
    AdService adService;

    @Autowired
    AuthorService authorService;

    @Override
    public Ad convert(AdDetailsDTO adDetailsDTO) {

        Ad ad = new Ad();

        if (adDetailsDTO.getId()!=null){
            ad = adService.findAd(adDetailsDTO.getId());

            if (ad==null){
                throw new IllegalStateException("Tried to modify a non-existant category");
            }
        }

        ad.setId(adDetailsDTO.getId());
        ad.setName(adDetailsDTO.getAdName());
        ad.setText(adDetailsDTO.getAdText());
//        ad.setAuthor(authorService.findByName(adDetailsDTO.getAuthorName()));
        ad.setCategory(adService.findAd(adDetailsDTO.getId()).getCategory());
        ad.setPostedDate(adDetailsDTO.getPostedDate());
        ad.setExpiryDate(adDetailsDTO.getExpiryDate());

        return ad;
    }
    public List<Ad> convert (List<AdDetailsDTO> adDetailsDTOS){
        List<Ad> ads = new ArrayList<>();

        for(AdDetailsDTO dto : adDetailsDTOS){
            ads.add(convert(dto));
        }

        return ads;
    }
}
