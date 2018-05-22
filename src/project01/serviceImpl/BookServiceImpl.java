package project01.serviceImpl;

import java.util.List;

import project01.dao.BookDao;
import project01.daoImpl.BookDaoImpl;
import project01.model.BookDto;
import project01.service.BookService;

public class BookServiceImpl implements BookService{
	
	private BookDao bookDao;
	
	public BookServiceImpl() {
		bookDao = new BookDaoImpl();
	}
	
	@Override
	public List<BookDto> searchBook(BookDto bookDto) {
		Double count = Double.valueOf(bookDao.countBook(bookDto));
		Integer totalRecord = (int) Math.ceil(count/bookDto.getPageSize());
		bookDto.setTotalPage(totalRecord);
		return bookDao.searchBook(bookDto);
	}

	@Override
	public boolean insertBook(BookDto dto) {
		return bookDao.insertBook(dto);
	}

	@Override
	public BookDto getBookById(String id) {
		return bookDao.getBookById(id);
	}

	@Override
	public boolean updateBook(BookDto dto) {
		return bookDao.updateBook(dto);
	}

	@Override
	public boolean deleteBook(String id) {
		return bookDao.deleteBook(id);
	}

}
