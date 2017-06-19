package jwd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import jwd.model.Author;
import jwd.repository.AuthorRepository;
import jwd.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

  @Autowired
  AuthorRepository authorRepository;

  @Override
  public Author findAuthor(Long id) {
    return authorRepository.findOne(id);
  }

  @Override
  public Author findByName(String name) {
    return authorRepository.findByName(name);
  }

  @Override
  public List<Author> findAll() {
    return authorRepository.findAll();
  }

  @Override
  public Author save(Author author) {
    return authorRepository.save(author);
  }

  @Override
  public void delete(Long id) {
    authorRepository.getOne(id);
  }
}
