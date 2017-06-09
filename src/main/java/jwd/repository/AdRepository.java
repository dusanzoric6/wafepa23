package jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import jwd.model.Ad;

@Repository
public interface AdRepository extends JpaRepository<Ad,Long> {
//  "select o from Oglas o where o.datumIsteka > :datumIsteka"
//  @Query("select a from Ad where a.expiryDate >= '2017-07-08'")
  List<Ad> findAll();
//  @Query("select * from jwd.ad where expiry_date > :expiryDate")
  List<Ad> findByExpiryDateAfter(Date date);
}
