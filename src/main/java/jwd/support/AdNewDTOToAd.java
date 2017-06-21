package jwd.support;

import jwd.model.Ad;
import jwd.service.AdService;
import jwd.service.AuthorService;
import jwd.service.CategoryService;
import jwd.web.dto.AdNewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;

@Component
public class AdNewDTOToAd implements Converter<AdNewDTO,Ad> {

    @Autowired
    AdService adService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AuthorService authorService;

    Date today = new Date(Calendar.getInstance().getTime().getTime());

    @Override
    public Ad convert(AdNewDTO adNewDTO) {
        Ad ad = new Ad();

        if (adNewDTO.getId()!=null){
            ad = adService.findAd(adNewDTO.getId());

            if (ad==null){
                throw new IllegalStateException("Tried to modify a non-existant category");
            }
        }

        ad.setId(adNewDTO.getId());
        ad.setName(adNewDTO.getAdName());
        ad.setText(adNewDTO.getAdText());
        ad.setPostedDate(today);
        ad.setExpiryDate(new Date(today.getTime() + 10*(1000 * 60 * 60 * 24)));
        ad.setCategory(categoryService.findCategory(adNewDTO.getCategoryId()));
//        ad.setAuthor(authorService.findByName(adNewDTO.getAuthorName()));

        return ad;
    }
}
