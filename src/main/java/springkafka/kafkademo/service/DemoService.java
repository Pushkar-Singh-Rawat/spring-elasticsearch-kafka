package springkafka.kafkademo.service;

import springkafka.kafkademo.messagemodel.MessageModel;

public interface DemoService {

	public void sendMessage(MessageModel message);
}
