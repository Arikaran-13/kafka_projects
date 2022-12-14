package com.zensar.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.zensar.dto.Product;
import com.zensar.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	
	@Autowired
	KafkaTemplate<String, Product> kafkaTemplate;
	
	@Override
	public String addItem(List<Product> products) {
		try {
		products.stream()
		        .forEach(product->kafkaTemplate.send("test-topic",product));
		}catch(Exception e) {
			System.out.println("Could not publish");
			e.printStackTrace();
		}
		return "Message published";
		
	}
	

}
