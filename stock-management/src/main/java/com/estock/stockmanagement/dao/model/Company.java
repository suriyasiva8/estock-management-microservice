package com.estock.stockmanagement.dao.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Company")
public class Company {
	
	@Id
	private String id;
	private String companyName;
	@Indexed(unique = true)
	private String companyCode;
	private String companyCeo;
	private String companyTurnOver;
	private String companyWebsite;
	private String companyStockExchange;
	List<Stock> companyStockPriceList;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyCeo() {
		return companyCeo;
	}
	public void setCompanyCeo(String companyCeo) {
		this.companyCeo = companyCeo;
	}
	public String getCompanyTurnOver() {
		return companyTurnOver;
	}
	public void setCompanyTurnOver(String companyTurnOver) {
		this.companyTurnOver = companyTurnOver;
	}
	public String getCompanyWebsite() {
		return companyWebsite;
	}
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}
	public String getCompanyStockExchange() {
		return companyStockExchange;
	}
	public void setCompanyStockExchange(String companyStockExchange) {
		this.companyStockExchange = companyStockExchange;
	}
	public List<Stock> getCompanyStockPriceList() {
		return companyStockPriceList;
	}
	public void setCompanyStockPriceList(List<Stock> companyStockPriceList) {
		this.companyStockPriceList = companyStockPriceList;
	}
	
}
