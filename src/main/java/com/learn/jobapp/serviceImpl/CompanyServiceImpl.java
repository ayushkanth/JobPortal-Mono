package com.learn.jobapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn.jobapp.entity.Company;
import com.learn.jobapp.repo.CompanyRepo;
import com.learn.jobapp.service.CompanyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepo companyRepo;

	@Override
	public List<Company> getAllCompanies() {
		return companyRepo.findAll();
	}

	@Override
	public boolean updateCompany(Long id, Company updatedCompany) {
		Optional<Company> companyOptional = companyRepo.findById(id);
		if (companyOptional.isPresent()) {
			Company company = companyOptional.get();
			company.setDescription(updatedCompany.getDescription());
			company.setName(updatedCompany.getName());
			;
			company.setJobs(updatedCompany.getJobs());
			companyRepo.save(company);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void createCompany(Company company) {
		companyRepo.save(company);
	}

	@Override
	public Company getCompanyById(Long id) {
		return companyRepo.findById(id).orElse(null);
	}

	@Override
	public boolean deleteCompanyById(Long id) {
		if (companyRepo.existsById(id)) {
			companyRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
