package springkafka.kafkademo.serviceimpl;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

import springkafka.kafkademo.messagemodel.MessageModel;
import springkafka.kafkademo.service.DemoService;
import springkafka.kafkademo.streams.KafkaStreamsDef;

@Service
public class DemoServiceImpl implements DemoService{
	private final KafkaStreamsDef kafkaStreamsDef;
    public DemoServiceImpl(KafkaStreamsDef kafkaStreamsDef) {
		this.kafkaStreamsDef=kafkaStreamsDef;
	}

	@Override
	public void sendMessage(final MessageModel message) {
		System.out.println("message: "+message.getSampleMessage());
		MessageChannel messageChannel=kafkaStreamsDef.producerChannel();
		messageChannel.send(MessageBuilder.withPayload(message).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
	}

	
}
