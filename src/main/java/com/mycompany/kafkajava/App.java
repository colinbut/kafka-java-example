package com.mycompany.kafkajava;

import com.mycompany.kafkajava.consumer.KafkaMessageConsumer;
import com.mycompany.kafkajava.producer.KafkaMessageSender;

import java.util.UUID;

public class App {

    public static void main( String[] args ) {
        final KafkaMessageConsumer kafkaMessageConsumer = new KafkaMessageConsumer();
        final KafkaMessageSender kafkaMessageSender = new KafkaMessageSender();

        new Thread(kafkaMessageConsumer::consumeMessage).start();

        new Thread(() -> {
            String message = "Message-" + UUID.randomUUID();
            kafkaMessageSender.sendMessage(message);
        }).start();
    }
}
