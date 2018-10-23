/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.kafkajava;

import com.mycompany.kafkajava.consumer.KafkaMessageReceiver;

public class ConsumerApp {

    public static void main(String[] args) {
        new Thread(new KafkaMessageReceiver()::consumeMessage).start();
    }
}
