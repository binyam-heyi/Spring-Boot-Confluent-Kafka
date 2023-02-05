package com.binyam.springbootconfluent.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic.name.firstTopic}")
    private String firstTopic;
    @Value("${spring.kafka.topic.name.firstTopic}")
    private String secondTopic;

    @Bean
    public NewTopic kafkaTopic1(){
        return TopicBuilder.name(firstTopic)
                .partitions(5)
                .replicas(3)
                .build();
    }
    @Bean
    public NewTopic kafkaJsonTopic1(){
        return TopicBuilder.name(secondTopic)
                .build();
    }
}