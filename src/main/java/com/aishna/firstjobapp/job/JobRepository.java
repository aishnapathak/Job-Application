package com.aishna.firstjobapp.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    void deleteByCompanyId(Long companyId);
}
