package com.gitspringboot.batch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.batch.core.JobExecutionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
@EnableScheduling
public class CsvFileToDatabaseJobLauncher {

   // private static final Logger LOGGER = LoggerFactory.getLogger(CsvFileToDatabaseJobLauncher.class);

    private final Job job;

    private final JobLauncher jobLauncher;

    @Autowired
    CsvFileToDatabaseJobLauncher(@Qualifier("csvFileToDatabaseJob") Job job, JobLauncher jobLauncher) {
        this.job = job;
        this.jobLauncher = jobLauncher;
    }

    //@Scheduled(fixedDelay=30000)
    @Scheduled(cron="0 0 12 * * *")
    void launchCsvFileToDatabaseJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        System.out.println("Starting csvFileToDatabase job");

        jobLauncher.run(job, newExecution());

        System.out.println("Stopping csvFileToDatabase job");
    }

    private JobParameters newExecution() {
        Map<String, JobParameter> parameters = new HashMap<>();

        JobParameter parameter = new JobParameter(new Date());
        parameters.put("currentTime", parameter);

        return new JobParameters(parameters);
}
}