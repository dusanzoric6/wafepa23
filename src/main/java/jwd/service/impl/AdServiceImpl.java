package jwd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import jwd.model.Ad;
import jwd.repository.AdRepository;
import jwd.service.AdService;

@Service
public class AdServiceImpl implements AdService {

  @Autowired
  AdRepository adRepository;

  @Override
  public Ad findAd(Long id) {
    return adRepository.findOne(id);
  }

  @Override
  public Page<Ad> findAll() {
    return adRepository.findByExpiryDateAfter(new Date(Calendar.getInstance().getTime().getTime()), new PageRequest(0,4));
  }

  @Override
  public Page<Ad> findAll(String sortAd, String directionAd) {
    return adRepository.findAll(new PageRequest(0,5, Sort.Direction.fromString(directionAd), sortAd));
  }

  @Override
  public Page<Ad> findByExpiryDateAfter(Date date) {

    return adRepository.findByExpiryDateAfter(date, new PageRequest(0,4));
  }

  @Override
  public Page<Ad> findByName(String nameSearch) {
    return adRepository.findByNameLike("%" + nameSearch + "%", new PageRequest(0,4));
  }



  @Override
  public Ad save(Ad ad) {
    return adRepository.save(ad);
  }

  @Override
  public void delete(Long id) {
    adRepository.delete(id);

  }
}
