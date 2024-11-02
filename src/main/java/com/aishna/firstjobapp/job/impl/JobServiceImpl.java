package com.aishna.firstjobapp.job.impl;

import com.aishna.firstjobapp.company.Company;
import com.aishna.firstjobapp.company.CompanyRepository;
import com.aishna.firstjobapp.job.Job;
import com.aishna.firstjobapp.job.JobRepository;
import com.aishna.firstjobapp.job.JobService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    public JobServiceImpl(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        Long companyId = job.getCompany().getId(); // Assume job has a `Company` set with ID

        // Check if company exists
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if (companyOptional.isPresent()) {
            // Set the found Company entity to the job
            job.setCompany(companyOptional.get());
            // Save the job
            jobRepository.save(job);
        } else {
            throw new EntityNotFoundException("Company with ID " + companyId + " does not exist.");
        }
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e) {
            return false;
        }
    }


    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()) {
            Job job= jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
                return true;
            }
        return false;
    }
}
