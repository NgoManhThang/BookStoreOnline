package project01.model;

import java.io.Serializable;

public class SearchDto implements Serializable{
	private Integer page;
	private Integer pageSize;
	private Integer totalPage;
	private Double fromPrice;
	private Double toPrice;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	public Double getFromPrice() {
		return fromPrice;
	}

	public void setFromPrice(Double fromPrice) {
		this.fromPrice = fromPrice;
	}

	public Double getToPrice() {
		return toPrice;
	}

	public void setToPrice(Double toPrice) {
		this.toPrice = toPrice;
	}

	public SearchDto() {
		page = 1;
		pageSize = 9;
	}

	public SearchDto(Integer page, Integer pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
}
