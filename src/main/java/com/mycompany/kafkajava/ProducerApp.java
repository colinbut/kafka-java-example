package com.mycompany.kafkajava;

import com.mycompany.kafkajava.producer.KafkaMessageSender;

public class ProducerApp {

    public static void main( String[] args ) {
        final KafkaMessageSender kafkaMessageSender = new KafkaMessageSender();

        new Thread(() -> kafkaMessageSender.sendMessage(25)).start();
    }
}
