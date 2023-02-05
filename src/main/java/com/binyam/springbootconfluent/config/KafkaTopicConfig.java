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
    @Value("${spring.kafka.topic.name.streamTopic}")
    private String streamTopic;

    @Value("${spring.kafka.topic.name.countTopic}")
    private String countTopic;

    @Bean
    public NewTopic kafkaTopic1(){
        return TopicBuilder.name(firstTopic)
                .partitions(5)
                .replicas(3)
                .build();
    }
    @Bean
    public NewTopic streamTopic(){
        return TopicBuilder.name(streamTopic)
                .build();
    }
    @Bean
    public NewTopic counts(){
        return TopicBuilder.name(countTopic)
                .partitions(6)
                .replicas(3)
                .build();
    }
}