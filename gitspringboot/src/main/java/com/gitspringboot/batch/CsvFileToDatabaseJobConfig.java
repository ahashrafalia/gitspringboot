package com.gitspringboot.batch;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class CsvFileToDatabaseJobConfig {

	@Bean
	ItemReader<CertCsv> csvFileItemReader() {
		FlatFileItemReader<CertCsv> csvFileReader = new FlatFileItemReader<>();
		csvFileReader.setResource(new ClassPathResource("csv/certfile.csv"));
		csvFileReader.setLinesToSkip(1);

		LineMapper<CertCsv> studentLineMapper = createStudentLineMapper();
		csvFileReader.setLineMapper(studentLineMapper);

		return csvFileReader;
	}

	@Bean
	ItemProcessor<CertCsv, CertCsv> csvFileItemProcessor() {
		
		return new CertCSVProcessor();
	}

	@Bean
	public ItemWriter<CertCsv> csvFileDatabaseItemWriter() {
		return new DbWriter();
	/*        JdbcBatchItemWriter<StudentDTO> databaseItemWriter = new JdbcBatchItemWriter<>();
	        databaseItemWriter.setDataSource(dataSource);
	        databaseItemWriter.setJdbcTemplate(jdbcTemplate);

	        databaseItemWriter.setSql(QUERY_INSERT_STUDENT);

	        ItemSqlParameterSourceProvider<StudentDTO> sqlParameterSourceProvider = studentSqlParameterSourceProvider();
	        databaseItemWriter.setItemSqlParameterSourceProvider(sqlParameterSourceProvider);

	        return databaseItemWriter;
*/
		/*return new ItemWriter<CertCsv>() {

			@Override
			public void write(List<? extends CertCsv> arg0) throws Exception {
				for (CertCsv msg : arg0) {
					System.out.println("Writing the data using batch writer: " + msg);
				}
				
			}

			
		};*/
	}
	@Bean
	public Step csvFileToDatabaseStep(ItemReader<CertCsv> csvFileItemReader,
			ItemProcessor<CertCsv, CertCsv> csvFileItemProcessor, ItemWriter<CertCsv> csvFileDatabaseItemWriter,
			StepBuilderFactory stepBuilderFactory) {
		
		return stepBuilderFactory.get("csvFileToDatabaseStep")
				.<CertCsv, CertCsv>chunk(2)
				.reader(csvFileItemReader)
				.processor(csvFileItemProcessor)
				.writer(csvFileDatabaseItemWriter)
				.build();
	}

	@Bean
	public Job csvFileToDatabaseJob(JobBuilderFactory jobBuilderFactory,
			@Qualifier("csvFileToDatabaseStep") Step csvStudentStep) {
		return jobBuilderFactory
				.get("csvFileToDatabaseJob")
				.incrementer(new RunIdIncrementer())
				.flow(csvStudentStep)
				.end().build();
	}

	private LineMapper<CertCsv> createStudentLineMapper() {
		DefaultLineMapper<CertCsv> studentLineMapper = new DefaultLineMapper<>();

		LineTokenizer studentLineTokenizer = createStudentLineTokenizer();
		studentLineMapper.setLineTokenizer(studentLineTokenizer);

		FieldSetMapper<CertCsv> studentInformationMapper = createStudentInformationMapper();
		studentLineMapper.setFieldSetMapper(studentInformationMapper);

		return studentLineMapper;
	}

	private LineTokenizer createStudentLineTokenizer() {
		DelimitedLineTokenizer studentLineTokenizer = new DelimitedLineTokenizer();
		studentLineTokenizer.setDelimiter(";");
		studentLineTokenizer.setNames(new String[] { "clientName", "status", "createdDate", "certName",
				"certCreatedDate", "renewedDate", "expDate", "certStatus","firstName","lastName",
				"phNo","email","country"});
		return studentLineTokenizer;
	}

	private FieldSetMapper<CertCsv> createStudentInformationMapper() {
		BeanWrapperFieldSetMapper<CertCsv> studentInformationMapper = new BeanWrapperFieldSetMapper<>();
		studentInformationMapper.setTargetType(CertCsv.class);
		return studentInformationMapper;
	}
}