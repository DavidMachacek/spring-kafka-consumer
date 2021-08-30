package com.david.kafka.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaService{

    private final ConsumerFactory<String, String> factory;

    public KafkaService(ConsumerFactory<String, String> factory) {
        this.factory = factory;
    }

    @KafkaListener(topics = "my-topic-replicated")
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(
                "Received Message: " + message + "from partition: " + partition);
    }
}
