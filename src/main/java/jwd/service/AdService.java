package jwd.service;

import org.springframework.data.domain.Page;

import java.sql.Date;
import java.util.List;
import jwd.model.Ad;

/**
 * Created by Dusan on 6/7/2017.
 */
public interface AdService {

  Ad findAd(Long id);
  Page<Ad> findAll();
  Page<Ad> findByExpiryDateAfter(Date date);
  Page<Ad> findByName(String nameSearch);
  Page<Ad> findAll(String sortAd, String directionCat);
  Ad save(Ad ad);
  void delete(Long id);
}
