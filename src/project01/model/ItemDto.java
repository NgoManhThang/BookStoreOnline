package project01.model;

import java.io.Serializable;

public class ItemDto implements Serializable {
	private BookDto bookDto;
	private int quantity;
	// Giá tại thời điểm bán, thường copy từ trường giá sang
	private double price;
	
	private double amountPayItem;

	public BookDto getBookDto() {
		return bookDto;
	}

	public void setBookDto(BookDto bookDto) {
		this.bookDto = bookDto;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getAmountPayItem() {
		return amountPayItem;
	}

	public void setAmountPayItem(double amountPayItem) {
		this.amountPayItem = amountPayItem;
	}

	public ItemDto(BookDto bookDto, int quantity, long price) {
		super();
		this.bookDto = bookDto;
		this.quantity = quantity;
		this.price = price;
	}

	public ItemDto() {
		super();
	}

}
