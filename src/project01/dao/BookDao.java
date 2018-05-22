package project01.dao;

import java.util.List;

import project01.model.BookDto;

public interface BookDao {
	public List<BookDto> searchBook(BookDto bookDto);
	
	public Long countBook(BookDto bookDto);
	
	boolean insertBook(BookDto dto);
	
	public BookDto getBookById(String id);
	
	boolean updateBook(BookDto dto);
	
	boolean deleteBook(String id);
}
