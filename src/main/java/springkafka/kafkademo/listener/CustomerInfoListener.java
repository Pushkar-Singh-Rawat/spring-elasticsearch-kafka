package springkafka.kafkademo.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import springkafka.kafkademo.model.Customer;
import springkafka.kafkademo.persistence.CustomerRepository;
import springkafka.kafkademo.streams.KafkaStreamsDef;

@Component
public class CustomerInfoListener {
	
	private CustomerRepository customerRepository;
	public CustomerInfoListener(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	@StreamListener(KafkaStreamsDef.CONSUMER)
	public void listenToKafkaEvent(@Payload Customer customer) {
		System.out.println("the customer name is "+ customer.getCustomerName());
		try {
		customerRepository.save(customer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
