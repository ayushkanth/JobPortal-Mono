package com.learn.jobapp.service;

import java.util.List;

import com.learn.jobapp.entity.Job;
import com.learn.jobapp.entity.Review;

public interface ReviewService {

	List<Review> findAllReviews(Long companyId);
	
	boolean createReview(Long companyId,Review review);
	
	Review getReviewById(Long companyId,Long reviewId);
	
	boolean deleteReviewById(Long companyId,Long reviewId);
	
	boolean updateReviewById(Long companyId,Long reviewId,Review upReview);
}
