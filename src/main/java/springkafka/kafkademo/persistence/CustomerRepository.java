package springkafka.kafkademo.persistence;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import springkafka.kafkademo.model.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String>{

}
