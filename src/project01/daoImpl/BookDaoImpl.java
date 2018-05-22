package project01.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project01.connection.JDBCConnection;
import project01.dao.BookDao;
import project01.model.BookDto;
import project01.ultis.NamedParamStatement;
import project01.ultis.StringUtils;

public class BookDaoImpl implements BookDao {

	private Connection connection = null;

	public BookDaoImpl() {
		connection = JDBCConnection.getJDBCConnection();
	}

	@Override
	public List<BookDto> searchBook(BookDto bookDto) {
		List<BookDto> lst = new ArrayList<>();
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			String sql = "select * from book bk left join code_decode cd on bk.category = cd.code and cd.code_group = 'CATEGORY' "
					+ " where 1 = 1";
			if (StringUtils.isNotNullOrEmpty(bookDto.getBookName())) {
				sql += " and upper(bk.book_name) like :p_book_name";
			}

			if (StringUtils.isNotNullOrEmpty(bookDto.getQuantity())) {
				sql += " and bk.quantity >= :p_quantity";
			}

			if (StringUtils.isNotNullOrEmpty(bookDto.getAuthor())) {
				sql += " and upper(bk.author) like :p_author";
			}

			if (StringUtils.isNotNullOrEmpty(bookDto.getCategory())) {
				sql += " and bk.category = :p_category";
			}

			if (bookDto.getFromPrice() != null) {
				sql += " and bk.price between :p_from_price and :p_to_price";
			}

			if (bookDto.getPage() != null && bookDto.getPageSize() != null) {
				sql += " LIMIT " + bookDto.getPageSize() + " OFFSET " + (bookDto.getPage() - 1) * bookDto.getPageSize();
			}

			NamedParamStatement preparedStatement = new NamedParamStatement(connection, sql);
			if (StringUtils.isNotNullOrEmpty(bookDto.getBookName())) {
				String bookName = "%" + bookDto.getBookName().toUpperCase() + "%";
				preparedStatement.setString("p_book_name", bookName);
			}
			if (StringUtils.isNotNullOrEmpty(bookDto.getPrice())) {
				preparedStatement.setString("p_quantity", bookDto.getQuantity());
			}
			if (StringUtils.isNotNullOrEmpty(bookDto.getAuthor())) {
				String author = "%" + bookDto.getAuthor().toUpperCase() + "%";
				preparedStatement.setString("p_author", author);
			}

			if (StringUtils.isNotNullOrEmpty(bookDto.getCategory())) {
				preparedStatement.setString("p_category", bookDto.getCategory());
			}

			if (bookDto.getFromPrice() != null) {
				preparedStatement.setDouble("p_from_price", bookDto.getFromPrice());
				preparedStatement.setDouble("p_to_price", bookDto.getToPrice());
			}

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				BookDto dto = new BookDto();
				dto.setId(Long.valueOf(rs.getLong("id")));
				dto.setBookName(rs.getString("book_name"));
				dto.setPrice(rs.getString("price"));
				dto.setDescription(rs.getString("description"));
				dto.setPathImage(rs.getString("path_image"));
				dto.setQuantity(rs.getString("quantity"));
				dto.setAuthor(rs.getString("author"));
				dto.setCategory(rs.getString("decode"));
				lst.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public Long countBook(BookDto bookDto) {
		Long count = 0l;
		Connection connection = JDBCConnection.getJDBCConnection();
		try {
			String sql = "select count(*) count from book bk where 1 = 1";
			if (StringUtils.isNotNullOrEmpty(bookDto.getBookName())) {
				sql += " and upper(bk.book_name) like :p_book_name";
			}
			if (StringUtils.isNotNullOrEmpty(bookDto.getQuantity())) {
				sql += " and bk.quantity >= :p_quantity";
			}
			if (StringUtils.isNotNullOrEmpty(bookDto.getAuthor())) {
				sql += " and upper(bk.author) like :p_author";
			}

			if (StringUtils.isNotNullOrEmpty(bookDto.getCategory())) {
				sql += " and bk.category = :p_category";
			}

			if (bookDto.getFromPrice() != null) {
				sql += " and bk.price between :p_from_price and :p_to_price";
			}

			NamedParamStatement preparedStatement = new NamedParamStatement(connection, sql);
			if (StringUtils.isNotNullOrEmpty(bookDto.getBookName())) {
				String bookName = "%" + bookDto.getBookName().toUpperCase() + "%";
				preparedStatement.setString("p_book_name", bookName);
			}
			if (StringUtils.isNotNullOrEmpty(bookDto.getPrice())) {
				preparedStatement.setString("p_quantity", bookDto.getQuantity());
			}
			if (StringUtils.isNotNullOrEmpty(bookDto.getAuthor())) {
				String author = "%" + bookDto.getAuthor().toUpperCase() + "%";
				preparedStatement.setString("p_author", author);
			}

			if (StringUtils.isNotNullOrEmpty(bookDto.getCategory())) {
				preparedStatement.setString("p_category", bookDto.getCategory());
			}

			if (bookDto.getFromPrice() != null) {
				preparedStatement.setDouble("p_from_price", bookDto.getFromPrice());
				preparedStatement.setDouble("p_to_price", bookDto.getToPrice());
			}

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				count = rs.getLong("count");
				return count;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean insertBook(BookDto dto) {
		try {
			String sql = "INSERT INTO book (book_name,price,description,path_image,quantity,author,category) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getBookName());
			preparedStatement.setString(2, dto.getPrice());
			preparedStatement.setString(3, dto.getDescription());
			preparedStatement.setString(4, dto.getPathImage());
			preparedStatement.setString(5, dto.getQuantity());
			preparedStatement.setString(6, dto.getAuthor());
			preparedStatement.setString(7, dto.getCategory());
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public BookDto getBookById(String id) {
		BookDto bookDto = new BookDto();
		try {
			String sql = "select * from book bk left join code_decode cd on bk.category = cd.code and cd.code_group = 'CATEGORY'"
					+ " where bk.id = :p_id";
			NamedParamStatement preparedStatement = new NamedParamStatement(connection, sql);
			preparedStatement.setString("p_id", id);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				bookDto.setId(Long.valueOf(rs.getLong("id")));
				bookDto.setBookName(rs.getString("book_name"));
				bookDto.setPrice(rs.getString("price"));
				bookDto.setDescription(rs.getString("description"));
				bookDto.setPathImage(rs.getString("path_image"));
				bookDto.setQuantity(rs.getString("quantity"));
				bookDto.setAuthor(rs.getString("author"));
				bookDto.setCategory(rs.getString("category"));
				bookDto.setCategoryDecode(rs.getString("decode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookDto;
	}

	@Override
	public boolean updateBook(BookDto dto) {
		try {
			String sql = "";
			if (StringUtils.isNotNullOrEmpty(dto.getPathImage())) {
				sql = "update book set book_name = ?,price = ?, description = ?, path_image = ?, quantity = ?, author = ?, category = ? where id = ?";
			} else {
				sql = "update book set book_name = ?,price = ?, description = ?, quantity = ?, author = ?, category = ? where id = ?";
			}

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			if (StringUtils.isNotNullOrEmpty(dto.getPathImage())) {
				preparedStatement.setString(1, dto.getBookName());
				preparedStatement.setString(2, dto.getPrice());
				preparedStatement.setString(3, dto.getDescription());
				preparedStatement.setString(4, dto.getPathImage());
				preparedStatement.setString(5, dto.getQuantity());
				preparedStatement.setString(6, dto.getAuthor());
				preparedStatement.setString(7, dto.getCategory());
				preparedStatement.setLong(8, dto.getId());
			} else {
				preparedStatement.setString(1, dto.getBookName());
				preparedStatement.setString(2, dto.getPrice());
				preparedStatement.setString(3, dto.getDescription());
				preparedStatement.setString(4, dto.getQuantity());
				preparedStatement.setString(5, dto.getAuthor());
				preparedStatement.setString(6, dto.getCategory());
				preparedStatement.setLong(7, dto.getId());
			}
			preparedStatement.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteBook(String id) {
		try {
			String sql = "delete from book where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
