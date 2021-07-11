package com.estock.stockmanagement.service;

import java.text.ParseException;
import java.util.List;

import com.estock.stockmanagement.dao.model.Company;
import com.estock.stockmanagement.dao.model.Stock;

public interface StockService {
	
	public Company addStock(String companyCode,double stockPrice);
	public List<Stock> getStock(String companyCode, String startDate,String endDate) throws ParseException;

}
