package com.learn.jobapp.service;

import java.util.List;

import com.learn.jobapp.entity.Company;

public interface CompanyService {

	List<Company> getAllCompanies();
	
	void createCompany(Company company);
	
	Company getCompanyById(Long id);
	
	boolean deleteCompanyById(Long id);
	
	boolean updateCompany(Long id,Company updatedCompany); 
}
