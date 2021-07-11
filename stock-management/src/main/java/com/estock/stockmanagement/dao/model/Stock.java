package com.estock.stockmanagement.dao.model;

import org.springframework.stereotype.Component;

@Component
public class Stock extends AuditorBaseObject {

	private double stockPrice;

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	
}
