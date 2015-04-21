/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muni.fi.dt.jz.batchhelloworld;

import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.ejb.Stateless;

/**
 *
 * @author Zorz
 */
@Stateless
public class BatchExecutionBean {
    
    public long submitJob() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties jobPropertis = new Properties();
        long executionId = jobOperator.start("first-batch-job", jobPropertis);
        return executionId;
    }
    
    public JobExecution getJobExecutionDetails(long executionId) {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        JobExecution jobExecution = jobOperator.getJobExecution(executionId);
        return jobExecution;
    }
 
    public long restartJob(long executionId) {
        Properties jobProperties = new Properties();
        long newExecutionId = 
          BatchRuntime.getJobOperator().restart(executionId, jobProperties);
        return newExecutionId;
    }
}
