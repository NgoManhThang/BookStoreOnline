package project01.service;

import java.util.List;

import project01.model.BookDto;

public interface BookService {
	
	public List<BookDto> searchBook(BookDto bookDto);
	
	boolean insertBook(BookDto dto);
	
	public BookDto getBookById(String id);
	
	public boolean updateBook(BookDto dto);
	
	public boolean deleteBook(String id);
}
