package com.binyam.springbootconfluent.stream;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
class Processor {

    @Value("${spring.kafka.topic.name.firstTopic}")
    private String firstTopic;

    @Value("${spring.kafka.topic.name.countTopic}")
    private String countTopic;
    @Autowired
    public void process(StreamsBuilder builder) {

        final Serde<Integer> integerSerde = Serdes.Integer();
        final Serde<String> stringSerde = Serdes.String();
        final Serde<Long> longSerde = Serdes.Long();

        KStream<Integer, String> textLines = builder.stream(firstTopic, Consumed.with(integerSerde, stringSerde));
        KTable<String, Long> wordCounts = textLines
                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
                .groupBy((key, value) -> value, Grouped.with(stringSerde, stringSerde))
                .count();

        wordCounts
                .toStream()
                .to(countTopic, Produced.with(stringSerde, longSerde));


    }
}