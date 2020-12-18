package com.biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.biblioteca.controller.BookController;
import com.biblioteca.entity.Book;
import com.biblioteca.service.BookService;

@WebMvcTest(BookController.class)
class CoBookTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService service;
	
	private final static String ROOT_PATH = "/biblioteca/book";
//	public ResponseEntity<?> obtenerLibro(Integer id) {
//		ResponseEntity<?> res = null;
//
//		if (bookRepository.existsById(id)) {
//			res = ResponseEntity.status(HttpStatus.OK).body(bookRepository.findBookById(id));
//		} else {
//			res = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra libro con id: " + id);
//		}
//
//		return res;
//	}
//	@Test
//	public void getLibro() {
//		Mockito.when(service.obtenerLibro(3))
//			//.thenThrow("No se encuentra libro con id: " + 3)
//			//.thenReturn(ResponseEntity<Book>.status(HttpStatus.OK).body(new Book());
//		
//		//mockMvc.perform(get(ROOT_PATH+"/3")).andExpect(status().isNotFound());
//		mockMvc.perform(get(ROOT_PATH+"/3")).andExpect(status().isOk());
//	}
//	@GetMapping(path = "/book/{id}")
//	public ResponseEntity<?> getBook(@PathVariable Integer id) {
//		return bookService.obtenerLibro(id);
//	}
	
//	@PostMapping(path = "/book")
//	public ResponseEntity<?> postBook(@RequestBody Book b) {
//		return bookService.crearLibro(b);
//	}
}
