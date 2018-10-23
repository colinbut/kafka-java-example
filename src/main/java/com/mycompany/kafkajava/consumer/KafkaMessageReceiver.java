/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.kafkajava.consumer;

import com.mycompany.kafkajava.config.KafkaConfig;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaMessageReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageReceiver.class);

    private static final int GIVE_UP = 100;

    public void consumeMessage(){
        final Consumer<Long, String> consumer = KafkaConfig.getConsumer();

        int recordsCount = 0;

        while (true) {
            ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);

            if (consumerRecords.count() == 0) {
                recordsCount++;
                if (recordsCount > GIVE_UP) {
                    break;
                } else {
                    continue;
                }
            }

            consumerRecords.forEach(consumerRecord -> LOGGER.info("Consumer Record:({} {}, {}, {})",
                consumerRecord.key(), consumerRecord.value(),
                consumerRecord.partition(), consumerRecord.offset()));

            consumer.commitAsync();
        }

        consumer.close();
        LOGGER.info("Done");
    }
}
