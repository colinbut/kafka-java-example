package com.mycompany.kafkajava;

import com.mycompany.kafkajava.consumer.KafkaMessageReceiver;
import com.mycompany.kafkajava.producer.KafkaMessageSender;

import java.util.UUID;

public class App {

    public static void main( String[] args ) {
        final KafkaMessageReceiver kafkaMessageReceiver = new KafkaMessageReceiver();
        final KafkaMessageSender kafkaMessageSender = new KafkaMessageSender();

        new Thread(kafkaMessageReceiver::consumeMessage).start();

        new Thread(() -> {
            String message = "Message-" + UUID.randomUUID();
            kafkaMessageSender.sendMessage(message);
        }).start();
    }
}
