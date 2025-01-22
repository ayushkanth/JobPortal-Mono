package com.learn.jobapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.jobapp.entity.Review;
import com.learn.jobapp.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/companies/{companyId}") @RequiredArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;
	
	@GetMapping("/reviews")
	public ResponseEntity<?> getAllReviews(@PathVariable Long companyId)
	{
		List<Review> allReviews = reviewService.findAllReviews(companyId);
		if(allReviews!=null) {
			return new ResponseEntity<List<Review>>(allReviews
				,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No Company found for id: "+companyId, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/reviews")
	public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review )
	{
		boolean isReviewSaved = reviewService.createReview(companyId, review);
		if(isReviewSaved) {
			return new ResponseEntity<String>("Review Added!!", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Review Not Saved,Company not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,
											@PathVariable Long reviewId)
	{
		Review reviewById = reviewService.getReviewById(companyId, reviewId);
		if(reviewById!=null) {
		return new ResponseEntity<Review>(reviewService.getReviewById(companyId, reviewId),
											HttpStatus.OK);
		}else {
			return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId,
										@PathVariable Long reviewId,
										@RequestBody Review updatedReview)
	{
		boolean isReviewUpdated = reviewService.updateReviewById(companyId, reviewId, updatedReview);
		if(isReviewUpdated)
		{
			return new ResponseEntity<String>("Review updated!!",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Review not found",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long companyId,
			@PathVariable Long reviewId)
	{
		boolean isReviewDeleted=reviewService.deleteReviewById(companyId, reviewId);
		if(isReviewDeleted)
		{
			return new ResponseEntity<String>("Review deleted!!",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Review not found",HttpStatus.NOT_FOUND);
	}
}
