package org.limite.contas.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnsConfig {

    @Value("${cloud.aws.region.sns.static}")
    private String regiao;

    @Value("${aws.sns.topic.limite.events.arn}")
    private String limiteEventsTopic;

    @Value("${cloud.aws.topic.endpoint}")
    private String endereco;


    @Bean
    public AmazonSNS amazonSNS() {
        return AmazonSNSClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withEndpointConfiguration(new AwsClientBuilder
                        .EndpointConfiguration(
                        endereco,
                        regiao))
                .build();
    }

    @Bean(name = "limiteEventsTopic")
    public Topic snsProductEventsTopic() {
        return new Topic().withTopicArn(limiteEventsTopic);
    }
}
