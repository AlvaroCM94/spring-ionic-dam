package org.alvaro.books.entity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import org.alvaro.books.entity.models.Libros;
import org.alvaro.books.entity.dao.BooksDAO;

public class BooksServiceImpl implements BooksService{
	
	@Autowired
	private BooksDAO booksDao;

	@Override
	public Optional<Libros> getOne(int id){
		return booksDao.findById(id);
	}

	@Override
	public List<Libros> getAll(){
		return (List<Libros>) booksDao.findAll();
	}

	@Override
	public void add(Libros libro){
		booksDao.save(libro);
	}

	@Override
	public void update(Libros libro, int id){
		
	}

	@Override
	public void delete(int id){
		booksDao.deleteById(id);
	}

}
