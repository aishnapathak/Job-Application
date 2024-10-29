package com.aishna.firstjobapp.job;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Data
public class Job {

    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

}
