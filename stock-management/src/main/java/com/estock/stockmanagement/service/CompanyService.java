package com.estock.stockmanagement.service;

import java.util.List;
import java.util.Optional;

import com.estock.stockmanagement.dao.model.Company;

public interface CompanyService {
	
	public Company saveCompanyDetails(Company companyData);
	public Optional<Company> getCompanyData(String companyCode);
	public List<Company> getAllCompanyData();
	public void deleteCompany(String companyCode);

}
