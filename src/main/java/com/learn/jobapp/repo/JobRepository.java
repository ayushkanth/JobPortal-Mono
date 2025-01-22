package com.learn.jobapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.jobapp.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

}
