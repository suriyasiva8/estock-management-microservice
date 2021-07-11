package com.estock.stockmanagement.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estock.stockmanagement.dao.model.Company;

@Repository
public interface CompanyRepo extends MongoRepository<Company,String>{
	
	Optional<Company> findByCompanyCode(String companyCode);
	Optional<Company> deleteByCompanyCode(String companyCode);
	
	
}
