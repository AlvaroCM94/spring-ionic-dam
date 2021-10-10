package org.alvaro.books.entity.dao;

import org.springframework.data.repository.CrudRepository;
import org.alvaro.books.entity.models.Libros;

public interface BooksDAO extends CrudRepository<Libros, Integer>{
	
}
