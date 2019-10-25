package springkafka.kafkademo.persistence;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import springkafka.kafkademo.model.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String>{

	public List<Customer> findByCustomerName(String name);
}
