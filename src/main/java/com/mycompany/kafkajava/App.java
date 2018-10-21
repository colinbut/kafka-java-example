package com.mycompany.kafkajava;

import com.mycompany.kafkajava.consumer.KafkaMessageReceiver;
import com.mycompany.kafkajava.producer.KafkaMessageSender;

public class App {

    public static void main( String[] args ) {
        final KafkaMessageReceiver kafkaMessageReceiver = new KafkaMessageReceiver();
        final KafkaMessageSender kafkaMessageSender = new KafkaMessageSender();

        new Thread(kafkaMessageReceiver::consumeMessage).start();

        new Thread(() -> kafkaMessageSender.sendMessage(25)).start();
    }
}
