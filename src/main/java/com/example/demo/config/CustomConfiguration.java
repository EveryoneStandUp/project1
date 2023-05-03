package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class CustomConfiguration {
	@Value("${aws.accessKeyId}")
	private String accessKeyId;
	@Value("${aws.secretAccessKey}")
	private String secretAccessKey;
	

	@Bean
	public S3Client s3client() {
		AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);
		AwsCredentialsProvider provider = StaticCredentialsProvider.create(credentials);
		
		S3Client s3client = S3Client.builder()
		.credentialsProvider(provider)
		.region(Region.AP_NORTHEAST_2)
		.build();
		
		return s3client;
	}
}
