package com.estock.stockmanagement;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.estock.stockmanagement.dao.model.Company;
import com.estock.stockmanagement.dao.model.Stock;
import com.estock.stockmanagement.repo.CompanyRepo;
import com.estock.stockmanagement.service.CompanyService;
import com.estock.stockmanagement.service.StockService;
import com.estock.stockmanagement.service.impl.CompanyServiceImpl;
import com.estock.stockmanagement.service.impl.StockServiceImpl;

class EstockServiceTest {

	@InjectMocks
	CompanyService companyService = new CompanyServiceImpl();

	@InjectMocks
	StockService stockService = new StockServiceImpl();

	@Mock
	CompanyRepo companyRepo;

	Company companyData;

	Stock stockData;

	@BeforeEach
	void init() {
		companyData = new Company();
		companyData.setCompanyCeo("Brain");
		companyData.setCompanyCode("CTS");
		companyData.setCompanyName("Cognizant");
		companyData.setCompanyStockExchange("BSE");
		companyData.setCompanyStockPriceList(Collections.emptyList());
		companyData.setCompanyTurnOver("100");
		companyData.setCompanyWebsite("cts.com");
		companyData.setId("1");
		stockData = new Stock();
		stockData.setCreatedByUser("siva");
		stockData.setCreationDate(LocalDate.now().toDate());
		stockData.setLastModifiedDate(LocalDate.now().toDate());
		stockData.setLastModifiedUserId("siva");
		stockData.setStockPrice(100);
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveCompanyDetails() {
		Mockito.when(companyRepo.save(companyData)).thenReturn(companyData);
		assertEquals(companyData, companyService.saveCompanyDetails(companyData));
	}

	@Test
	void getCompanyData() {
		Mockito.when(companyRepo.findByCompanyCode("CTS")).thenReturn(Optional.of(companyData));
		assertEquals(Optional.of(companyData), companyService.getCompanyData("CTS"));
	}

	@Test
	void getAllCompanyData() {
		Mockito.when(companyRepo.findAll()).thenReturn(List.of(companyData));
		assertEquals(1, companyService.getAllCompanyData().size());
	}

	@Test
	void deleteCompany() {
		Mockito.when(companyRepo.deleteByCompanyCode("CTS")).thenReturn(Optional.of(companyData));
		companyService.deleteCompany("CTS");
		assertNotNull(companyData);
	}

	@Test
	void addStock() {
		Mockito.when(companyRepo.findByCompanyCode("CTS")).thenReturn(Optional.of(companyData));
		Mockito.when(companyRepo.save(Mockito.any())).thenReturn(companyData);
		assertNotNull(stockService.addStock("CTS", 100));
	}

	@Test
	void getStock() throws ParseException {
		companyData.setCompanyStockPriceList(List.of(stockData));
		Mockito.when(companyRepo.findByCompanyCode(Mockito.anyString())).thenReturn(Optional.of(companyData));
		assertNotNull(stockService.getStock("CTS", LocalDate.now().toString("yyyy-MM-dd"),
				LocalDate.now().toString("yyyy-MM-dd")));

	}

}