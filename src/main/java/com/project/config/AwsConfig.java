package com.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
public class AwsConfig {

	/* s3 버킷 관련 credential 설정 */
	@Value("${aws.s3.accessKey}")
	private String accessKey;
	@Value("${aws.s3.secretKey}")
	private String secretKey;
	@Value("${aws.s3.region}")
	private String region;

	/* ses 관련 credential 설정 */
	@Value("${aws.ses.accessKey}")
	private String accessKeySES;
	@Value("${aws.ses.secretKey}")
	private String secretKeySES;
	@Value("${aws.ses.region}")
	private String regionSES;

	@Bean
	public AmazonS3 amazonS3() {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
		return AmazonS3ClientBuilder.standard().withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
	}

	@Bean
	public AmazonSimpleEmailService amazonSimpleEmailService() {
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKeySES, secretKeySES);
		return AmazonSimpleEmailServiceClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(regionSES).build();
	}
}
