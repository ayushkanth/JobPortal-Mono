package com.learn.jobapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.jobapp.entity.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long>{

}
