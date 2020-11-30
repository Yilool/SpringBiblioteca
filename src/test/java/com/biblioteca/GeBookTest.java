package com.biblioteca;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.biblioteca.entity.Book;
import com.biblioteca.entity.Page;
import com.biblioteca.repository.BookRepository;
import com.biblioteca.repository.PageRepository;
import com.biblioteca.service.BookService;

class GeBookTest {
	//Subject Under Test
	private BookService sut;
	//Dependencias
	private BookRepository mockBookRepository;
	private PageRepository mockPageRepository;
	
	private Book mockBook;
	private Page mockPage;
	private ArrayList<Page> mockPages;
	
	@BeforeEach
	private void init() {
		sut = new BookService();
		mockPageRepository = mock(PageRepository.class);
		mockBookRepository = mock(BookRepository.class);
		
		sut.setBookRepository(mockBookRepository);
		sut.setPageRepository(mockPageRepository);
	}
	
	@Test
	public void obtenerLibroExiste() {
		mockBook = mock(Book.class);
		
		Mockito.when(mockBookRepository.existsById(3)).thenReturn(true);
			when(mockBookRepository.findBookById(3)).thenReturn(mockBook);

		assert(sut.obtenerLibro(3).getBody().equals(mockBook));
	}

	@Test
	public void obtenerLibroNoExiste() {
		mockBook = mock(Book.class);
		
		Mockito.when(mockBookRepository.existsById(3)).thenReturn(false);
		
		assert(sut.obtenerLibro(3).getBody().equals("No se encuentra libro con id: " + 3));
	}
	
	@Test
	public void crearLibroT() {
		mockBook = mock(Book.class);
		mockPages = new ArrayList<Page>();
		
		Mockito.when(mockBook.getPages()).thenReturn(mockPages);
			when(mockPages.forEach(p -> mockPageRepository.save(mockPage))).thenReturn(mockPage);
			when(mockBookRepository.save(mockBook)).thenReturn(mockBook);
		
		assert(sut.crearLibro(mockBook).getBody().equals(mockBook));
	}
	
//	public ResponseEntity<?> crearLibro(Book b) {
//		ResponseEntity<?> res = null;
//
//		b.getPages().forEach(p -> pageRepository.save(p));
//		bookRepository.save(b);
//		res = ResponseEntity.status(HttpStatus.OK).body(b);
//
//		return res;
//	}

}
