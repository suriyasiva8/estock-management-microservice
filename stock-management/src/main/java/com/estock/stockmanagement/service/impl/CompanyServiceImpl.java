package com.estock.stockmanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estock.stockmanagement.dao.model.Company;
import com.estock.stockmanagement.repo.CompanyRepo;
import com.estock.stockmanagement.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	CompanyRepo companyRepo;

	@Override
	public Company saveCompanyDetails(Company companyData) {
		return companyRepo.save(companyData);
	}

	@Override
	public Optional<Company> getCompanyData(String companyCode) {
		return companyRepo.findByCompanyCode(companyCode);
	}

	@Override
	public List<Company> getAllCompanyData() {
		return companyRepo.findAll();
	}

	@Override
	public void deleteCompany(String companyCode) {
		companyRepo.deleteByCompanyCode(companyCode);
	}

}
