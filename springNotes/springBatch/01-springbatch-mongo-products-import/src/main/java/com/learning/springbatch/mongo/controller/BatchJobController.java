package com.learning.springbatch.mongo.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/batch")
public class BatchJobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importProductsJob;

    @Autowired
    private JobRepository jobRepository;

    @PostMapping("/products/import")
    public ResponseEntity<Map<String, Object>> importProducts() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

            JobExecution jobExecution = jobLauncher.run(importProductsJob, jobParameters);

            Map<String, Object> response = new HashMap<>();
            response.put("jobId", jobExecution.getJobId());
            response.put("status", jobExecution.getStatus());
            response.put("startTime", jobExecution.getStartTime());
            response.put("endTime", jobExecution.getEndTime());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Failed to start job: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<Map<String, Object>> getJobStatus(@PathVariable Long jobId) {
        JobExecution jobExecution = jobRepository.getLastJobExecution(importProductsJob.getName(), new JobParameters());

        if (jobExecution == null) {
            return ResponseEntity.notFound().build();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("jobId", jobExecution.getJobId());
        response.put("status", jobExecution.getStatus());
        response.put("startTime", jobExecution.getStartTime());
        response.put("endTime", jobExecution.getEndTime());
        response.put("exitStatus", jobExecution.getExitStatus());
        response.put("stepExecutions", jobExecution.getStepExecutions().size());

        return ResponseEntity.ok(response);
    }
}

