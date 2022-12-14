package com.zensar.serviceImpl;

import com.zensar.dto.Product;
import com.zensar.kafkaconstants.KafkaConstants;
import com.zensar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    KafkaTemplate<String,Product>kafkaTemplate;

    @Override
    public String addProduct(List<Product> products) {

        if(!products.isEmpty()){
           for(Product i : products){
               if(i !=null) {
                   kafkaTemplate.send(KafkaConstants.TOPICNAME, i);
                   System.out.println("Added into kafka topic");
               }
               else{
                   return "Product is null";
               }
           }

        }
        return "Added successfully intp kafka";
    }
}
