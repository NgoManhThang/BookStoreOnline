package project01.model;

import java.io.Serializable;

public class BookDto extends SearchDto {
	private Long id;
	private String bookName;
	private String price;
	private String description;
	private String pathImage;
	private String quantity;
	private String author;
	private String category;
	private String categoryDecode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategoryDecode() {
		return categoryDecode;
	}

	public void setCategoryDecode(String categoryDecode) {
		this.categoryDecode = categoryDecode;
	}

	public BookDto(Long id, String bookName, String price, String description, String pathImage, String quantity,
			String author, String category) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.price = price;
		this.description = description;
		this.pathImage = pathImage;
		this.quantity = quantity;
		this.author = author;
		this.category = category;
	}

	public BookDto() {
		super();
	}
}
