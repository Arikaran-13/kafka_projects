package com.zensar.serviceImpl;

import com.zensar.dto.Product;
import com.zensar.kafkaconstants.KafkaConstants;
import com.zensar.service.ProductConsumerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductConsumerService {
    @Override
    @KafkaListener(topics = KafkaConstants.TOPICNAME, groupId = KafkaConstants.GROUPID)
    public String receiveProduct(Product products) {
        System.out.println(products);
        System.out.println("Message received from kafka topic");
        return "Message received";
    }
}
