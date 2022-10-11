package org.saldo.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfig {

	@Value("${cloud.aws.queue.endpoint}")
	private String endereco;

	@Value("${cloud.aws.region.static}")
	private String regiao;

	@Bean
	public AmazonSQSAsync amazonSQS() {
		return AmazonSQSAsyncClientBuilder.standard()
				.withCredentials(new DefaultAWSCredentialsProviderChain())
				.withEndpointConfiguration(new AwsClientBuilder
						.EndpointConfiguration(
						endereco,
						regiao))
				.build();
	}
}