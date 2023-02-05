package com.binyam.springbootconfluent.controller;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequiredArgsConstructor
//public class StreamWordCountController {
//
//    private final StreamsBuilderFactoryBean factoryBean;
//
//    @GetMapping("/count/{word}")
//    public Long getCount(@PathVariable String word){
//        final KafkaStreams kafkaStreams =  factoryBean.getKafkaStreams();
//        return (Long) kafkaStreams
//                .store(StoreQueryParameters.fromNameAndType("word-counts", QueryableStoreTypes.keyValueStore()))
//                .get(word);
//
//    }
//}
