package com.mycompany.kafkajava;

import com.mycompany.kafkajava.producer.KafkaMessageSender;

public class ProducerApp {

    public static void main( String[] args ) {
        new Thread(() -> new KafkaMessageSender().sendMessage(25)).start();
    }
}
