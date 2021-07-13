package com.estock.stockmanagement;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import com.estock.stockmanagement.controller.EStockController;
import com.estock.stockmanagement.dao.model.Company;
import com.estock.stockmanagement.dao.model.Stock;
import com.estock.stockmanagement.service.CompanyService;
import com.estock.stockmanagement.service.StockService;

class EstockControllerTest {

	@InjectMocks
	EStockController estockCont;

	@Mock
	StockService stockService;

	@Mock
	CompanyService compService;

	Company data;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void init() {
		data = new Company();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testRegisterCompany() {

		Mockito.when(compService.saveCompanyDetails(Mockito.any())).thenReturn(data);
		assertEquals(HttpStatus.CREATED, estockCont.registerCompany(data).getStatusCode());
	}

	@Test
	void testGetCompanyData() {
		Optional<Company> data1 = Optional.empty();
		Mockito.when(this.compService.getCompanyData(Mockito.any())).thenReturn(data1);
		assertEquals(HttpStatus.NO_CONTENT, estockCont.getCompanyData(null).getStatusCode());
		Optional<Company> data = Optional.of(new Company());
		Mockito.when(this.compService.getCompanyData(Mockito.any())).thenReturn(data);
		assertEquals(HttpStatus.OK, estockCont.getCompanyData("CTS").getStatusCode());
	}

	@Test
	void testGetAllCompanyData() {
		Mockito.when(compService.getAllCompanyData()).thenReturn(Collections.emptyList());
		assertEquals(HttpStatus.NO_CONTENT, estockCont.getAllCompanyData().getStatusCode());
		List<Company> compList = new ArrayList<>();
		compList.add(data);
		Mockito.when(compService.getAllCompanyData()).thenReturn(compList);
		assertEquals(HttpStatus.OK, estockCont.getAllCompanyData().getStatusCode());
	}

	@Test
	void testDeleteCompanyData() {
		Mockito.doNothing().when(compService).deleteCompany(Mockito.any());
		assertEquals(HttpStatus.OK, estockCont.deleteCompanyData("CTS").getStatusCode());
	}

	@Test
	void testAddStockPrice() {
		Mockito.when(stockService.addStock(Mockito.any(), Mockito.anyDouble())).thenReturn(data);
		Stock stockPrice = new Stock();
		stockPrice.setStockPrice(50);
		assertEquals(HttpStatus.CREATED, estockCont.addStockPrice("CTS", stockPrice).getStatusCode());
	}

	@Test
	void testGetStockPrice() throws ParseException {
		Mockito.when(stockService.getStock(Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(Collections.emptyList());
		assertEquals(HttpStatus.OK,
				estockCont.getStockPrice(Mockito.any(), Mockito.any(), Mockito.any()).getStatusCode());
	}

}