package com.estock.stockmanagement.controller;

import java.text.ParseException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.stockmanagement.dao.model.Company;
import com.estock.stockmanagement.dao.model.Stock;
import com.estock.stockmanagement.service.CompanyService;
import com.estock.stockmanagement.service.StockService;

@RestController
@RequestMapping("/api/v1.0/market")
public class EStockController {

	@Autowired
	CompanyService companyService;
	
	@Autowired
	StockService stockService;

	@PostMapping("/company/register")
	public ResponseEntity<Company> registerCompany(@RequestBody Company companyData) {
		Company company = companyService.saveCompanyDetails(companyData);
		return new ResponseEntity<>(company, HttpStatus.CREATED);
	}

	@GetMapping("/company/info/{companyCode}")
	public ResponseEntity<Company> getCompanyData(@PathVariable String companyCode) {
		Optional<Company> company = companyService.getCompanyData(companyCode);
		if (company.isPresent()) {
			return new ResponseEntity<>(company.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Company(), HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/company/getall")
	public ResponseEntity<List<Company>> getAllCompanyData() {
		List<Company> company = companyService.getAllCompanyData();
		if (!CollectionUtils.isEmpty(company)) {
			return new ResponseEntity<>(company, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(company, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/company/delete/{companyCode}")
	public ResponseEntity<HttpStatus> deleteCompanyData(@PathVariable String companyCode) {
		companyService.deleteCompany(companyCode);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/stock/add/{companyCode}")
	public ResponseEntity<Company> addStockPrice(@PathVariable String companyCode,@RequestBody Stock stockPrice) {
		Company company=stockService.addStock(companyCode,stockPrice.getStockPrice());
		return new ResponseEntity<>(company,HttpStatus.CREATED);
	}
	
	@GetMapping("/stock/get/{companyCode}/{startDate}/{endDate}")
	public ResponseEntity<List<Stock>> getStockPrice(@PathVariable String companyCode,@PathVariable String startDate,@PathVariable String endDate) throws ParseException {
		List<Stock> stockList=stockService.getStock(companyCode, startDate, endDate);
		return new ResponseEntity<>(stockList,HttpStatus.OK);
	}

}
