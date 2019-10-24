package springkafka.kafkademo.streamBinding;

import org.springframework.cloud.stream.annotation.EnableBinding;

import springkafka.kafkademo.streams.KafkaStreamsDef;

@EnableBinding(KafkaStreamsDef.class)
public class StreamBinding {

}
