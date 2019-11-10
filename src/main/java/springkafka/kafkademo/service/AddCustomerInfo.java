package springkafka.kafkademo.service;

import org.springframework.http.ResponseEntity;

import springkafka.kafkademo.model.Customer;

public interface AddCustomerInfo {

	public Customer configureCustomerInfo(Customer customer);
}
