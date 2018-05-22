package project01.model;

import java.io.Serializable;
import java.util.List;

public class OrderDto implements Serializable {
	private List<ItemDto> lstItems;
	private UserDto customer;
	private Double totalPayment;


	public List<ItemDto> getLstItems() {
		return lstItems;
	}

	public void setLstItems(List<ItemDto> lstItems) {
		this.lstItems = lstItems;
	}

	public UserDto getCustomer() {
		return customer;
	}

	public void setCustomer(UserDto customer) {
		this.customer = customer;
	}

	public Double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(Double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public OrderDto(List<ItemDto> lstItems, UserDto customer, Double totalPayment) {
		super();
		this.lstItems = lstItems;
		this.customer = customer;
		this.totalPayment = totalPayment;
	}

	public OrderDto() {
		super();
	}

}
