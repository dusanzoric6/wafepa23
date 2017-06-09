package jwd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.model.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
