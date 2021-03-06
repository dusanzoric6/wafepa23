package jwd.service;

import java.util.List;
import jwd.model.Author;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Dusan on 6/7/2017.
 */
public interface AuthorService extends UserDetailsService {

  Author findAuthor(Long id);
  Author findByName(String name);
  List<Author> findAll();
//  Page<Author> findAll(String sortCat, String directionCat);
  Author save(Author author);
  void delete(Long id);
}
