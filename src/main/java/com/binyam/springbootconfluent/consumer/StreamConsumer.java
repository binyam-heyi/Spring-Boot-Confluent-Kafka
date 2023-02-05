package com.binyam.springbootconfluent.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
public
class StreamConsumer {
    @KafkaListener(topics = {"${spring.kafka.topic.name.countTopic}"}, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Long> record) {
        System.out.println("received = " + record.value() + " with key " + record.key());
    }
}
