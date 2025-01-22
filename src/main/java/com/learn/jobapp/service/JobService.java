package com.learn.jobapp.service;

import java.util.List;

import com.learn.jobapp.entity.Job;

public interface JobService {

	public List<Job> findAll();
	
	public void createJob(Job job);
	
	public Job getJobById(Long id);
	
	public boolean deleteJobById(Long id);
	
	public boolean updateJobById(Long id, Job updateJob);
	
 }
