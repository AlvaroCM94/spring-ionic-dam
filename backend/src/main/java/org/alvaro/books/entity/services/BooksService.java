package org.alvaro.books.entity.services;

import java.util.List;
import java.util.Optional;

import org.alvaro.books.entity.models.Libros;

public interface BooksService {
	Optional<Libros> getOne(int id);
	List<Libros> getAll();
	void add(Libros libro);
	void update(Libros libro, int id);
	void delete(int id);
}
