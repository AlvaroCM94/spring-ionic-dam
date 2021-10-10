package org.alvaro.books.controllers;

import java.util.List;
import java.util.Optional;

import org.alvaro.books.entity.models.Libros;
import org.alvaro.books.entity.services.BooksService;

//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class BooksController {

	@Autowired
	BooksService booksService;

	@GetMapping("/libros")
	List<Libros> getAll(){
		return booksService.getAll();
	}

	@GetMapping("/libros/{id}")
	Libros getOne(@PathVariable("id") int id) {
		Optional<Libros> l = booksService.getOne(id);

		if(l.isPresent()) {
			return l.get();
		};

		return null;
	}

	@PostMapping("/libros")
	void add(Libros libro) {
		System.out.println(libro.getNombre());
		booksService.add(libro);
	}

	@PostMapping(value="/libros", consumes="application/json")
	void addUsingJson(@RequestBody String bookString) {
		ObjectMapper om = new ObjectMapper();
		try {
			Libros book = om.readValue(bookString, Libros.class);
			booksService.add(book);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@DeleteMapping("/libros/{id}")
	void delete(@PathVariable("id") int id) {
		System.out.println(id);
		booksService.delete(id);
	}

}
