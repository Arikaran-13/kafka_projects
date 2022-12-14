package com.zensar.config;


import com.zensar.dto.Product;
import com.zensar.kafkaconstants.KafkaConstants;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import org.apache.kafka.common.serialization.StringDeserializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


import java.util.HashMap;


@Configuration
@EnableKafka
public class ConsumerProductConfig {

    @Bean
    public ConsumerFactory<String, Product>consumerFactory(){
        HashMap<String , Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.HOST);
        config.put(ConsumerConfig.GROUP_ID_CONFIG,KafkaConstants.GROUPID);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(), new JsonDeserializer<>(Product.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Product> kafkaListner(){
        ConcurrentKafkaListenerContainerFactory<String,Product> listner = new ConcurrentKafkaListenerContainerFactory<>();
        listner.setConsumerFactory(consumerFactory());
        return listner;
    }
}
