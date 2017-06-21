package jwd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import jwd.model.Ad;

@Repository
public interface AdRepository extends PagingAndSortingRepository<Ad,Long> {
  Page<Ad> findByExpiryDateAfter(Date date, Pageable pageable);
  Page<Ad> findByNameLike(String name, Pageable pageable);

}
