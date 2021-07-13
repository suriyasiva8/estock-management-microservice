package com.estock.stockmanagement.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.estock.stockmanagement.dao.model.Company;
import com.estock.stockmanagement.dao.model.Stock;
import com.estock.stockmanagement.repo.CompanyRepo;
import com.estock.stockmanagement.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	CompanyRepo companyRepo;

	@Override
	public Company addStock(String companyCode, double stockPrice) {
		Optional<Company> comp = companyRepo.findByCompanyCode(companyCode);
		if (comp.isPresent()) {
			Company compData = comp.get();
			List<Stock> stockLst = compData.getCompanyStockPriceList();
			Stock stck = new Stock();
			stck.setStockPrice(stockPrice);
			if (CollectionUtils.isEmpty(stockLst)) {
				stockLst = new ArrayList<>();
			}
			stockLst.add(stck);
			compData.setCompanyStockPriceList(stockLst);
			return companyRepo.save(compData);
		}
		return null;
	}

	@Override
	public List<Stock> getStock(String companyCode, String startDate, String endDate) throws ParseException {
		Optional<Company> comp = companyRepo.findByCompanyCode(companyCode);

		LocalDate firstDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate).toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate lastDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate).toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate();
		if (comp.isPresent()) {
			Company compData = comp.get();
			List<Stock> stockLst = compData.getCompanyStockPriceList();
			if (CollectionUtils.isEmpty(stockLst)) {
				stockLst = new ArrayList<>();
			}
			return stockLst.stream().filter(x -> compareDates(x.getCreationDate(), firstDate, lastDate))
					.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	private boolean compareDates(Date creationDate, LocalDate startDate, LocalDate endDate) {
		LocalDate createdDate = creationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return (createdDate.compareTo(startDate) >= 0 && createdDate.compareTo(endDate) <= 0);
	}
	

}
