package com.learn.jobapp.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.jobapp.entity.Company;
import com.learn.jobapp.entity.Review;
import com.learn.jobapp.repo.ReviewRepo;
import com.learn.jobapp.service.CompanyService;
import com.learn.jobapp.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

	private final ReviewRepo reviewRepo;
	private final CompanyService companyService;
	
	
	@Override
	public List<Review> findAllReviews(Long companyId) {
		Company companyById = companyService.getCompanyById(companyId);
		if(companyById!=null) {
			List<Review> reviews = reviewRepo.findByCompanyId(companyId);
			return reviews;
		}else {
			return null;
		}
	}

	@Override
	public boolean createReview(Long companyId,Review review) {
		Company companyById = companyService.getCompanyById(companyId);
		if(companyById!=null)
		{
			review.setCompany(companyById);
			reviewRepo.save(review);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Review getReviewById(Long companyId, Long reviewId) {
		List<Review> reviews = reviewRepo.findByCompanyId(companyId);
		return reviews.stream()
				.filter(r->r.getId().equals(reviewId))
				.findFirst().orElse(null);
	}

	@Override
	public boolean updateReviewById(Long companyId, Long reviewId, Review updatedReview) {
		Company companyById = companyService.getCompanyById(companyId);
		Review reviewById = getReviewById(companyId, reviewId);
		//companyById.getReviews().stream().filter(r->r.getId().equals(reviewById)).findFirst()
		if(companyById!=null && reviewById!=null)
		{
			updatedReview.setCompany(companyById);
			updatedReview.setId(reviewId);
			reviewRepo.save(updatedReview);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteReviewById(Long companyId, Long reviewId) {
		if(companyService.getCompanyById(companyId)!=null &&
				reviewRepo.existsById(reviewId))
		{
			Review review = reviewRepo.findById(reviewId).get();
			Company company = review.getCompany();
			company.getReviews().remove(review);
			review.setCompany(null);
			companyService.updateCompany(companyId, company);
			reviewRepo.deleteById(reviewId);
			return true;
		}
		return false;
	}



}
