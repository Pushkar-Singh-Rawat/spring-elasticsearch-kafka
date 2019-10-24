package springkafka.kafkademo.serviceimpl;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

import springkafka.kafkademo.model.Customer;
import springkafka.kafkademo.service.AddCustomerInfo;
import springkafka.kafkademo.streams.KafkaStreamsDef;

@Service
public class AddCustomerInfoImpl implements AddCustomerInfo{
	private final KafkaStreamsDef kafkaStreamsDef;
    public AddCustomerInfoImpl(KafkaStreamsDef kafkaStreamsDef) {
		this.kafkaStreamsDef=kafkaStreamsDef;
	}

	@Override
	public void configureCustomerInfo(final Customer customer) {
		System.out.println("message: "+customer.getCustomerName());
		MessageChannel messageChannel=kafkaStreamsDef.producerChannel();
		messageChannel.send(MessageBuilder.withPayload(customer).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
	}

	
}
