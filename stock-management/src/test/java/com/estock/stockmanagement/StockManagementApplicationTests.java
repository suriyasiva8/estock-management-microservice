package com.estock.stockmanagement;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.estock.stockmanagement.controller.EStockController;
import com.estock.stockmanagement.service.CompanyService;
import com.estock.stockmanagement.service.StockService;

@SpringBootTest
class StockManagementApplicationTests {
	
	@InjectMocks
	EStockController estockController;
	
	@Mock
	CompanyService companyService;
	
	@Mock
	StockService stockService;

	@Test
	public void testRegisterCompany() {
		
	}

}
