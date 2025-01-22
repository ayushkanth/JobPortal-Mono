package com.learn.jobapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.jobapp.entity.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long>{
	List<Review> findByCompanyId(Long companyId);
}
