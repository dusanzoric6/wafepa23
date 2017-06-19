package jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Author findByName(String name);
}
