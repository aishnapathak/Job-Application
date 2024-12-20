package com.aishna.firstjobapp.job;

import com.aishna.firstjobapp.company.Company;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="job_table")
@Data
public class Job {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    @ManyToOne
    private Company company;

}
