package com.learn.jobapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn.jobapp.entity.Job;
import com.learn.jobapp.repo.JobRepository;
import com.learn.jobapp.service.JobService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class JobServiceImpl implements JobService{

	private final JobRepository jobRepository;
	
	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		 jobRepository.save(job);		
	}

	@Override
	public Job getJobById(Long id) {
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Long id) {
		try {
			jobRepository.deleteById(id);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateJobById(Long id, Job updateJob) {
		Optional<Job> jobOptional = jobRepository.findById(id);
		if(jobOptional.isPresent())
		{
			Job job = jobOptional.get();
			job.setDescription(updateJob.getDescription());
			job.setLocation(updateJob.getLocation());
			job.setMaxSalary(updateJob.getMaxSalary());
			job.setMinSalary(updateJob.getMinSalary());
			job.setTitle(updateJob.getTitle());
			jobRepository.save(job);
			return true;
		}
		return false;
	}

}
