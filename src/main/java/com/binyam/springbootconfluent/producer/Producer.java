package com.binyam.springbootconfluent.producer;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
class Producer {

    private final KafkaTemplate<Integer, String> template;
    @Value("${spring.kafka.topic.name.firstTopic}")
    private String firstTopic;

    Faker faker;

    @EventListener(ApplicationStartedEvent.class)
    public void generate() {

        faker = Faker.instance();
        final Flux<Long> interval = Flux.interval(Duration.ofMillis(1_000));

        final Flux<String> quotes = Flux.fromStream(Stream.generate(() -> faker.hobbit().quote()));

        Flux.zip(interval, quotes)
                .map(it -> template.send(firstTopic, faker.random().nextInt(42), it.getT2())).blockLast();
    }

}
