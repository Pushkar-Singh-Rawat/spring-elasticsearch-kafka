package springkafka.kafkademo.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import springkafka.kafkademo.messagemodel.MessageModel;
import springkafka.kafkademo.streams.KafkaStreamsDef;

@Component
public class DemoListener {
	
	@StreamListener(KafkaStreamsDef.CONSUMER)
	public void listenToKafkaEvent(@Payload MessageModel message) {
		System.out.println("the message is "+ message.getSampleMessage());
	}

}
