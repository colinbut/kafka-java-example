/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.kafkajava.producer;

import com.mycompany.kafkajava.config.KafkaConfig;
import com.mycompany.kafkajava.constants.KafkaConstants;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaMessageSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageSender.class);

    public void sendMessage(int numberOfMessageToSend) {
        final Producer<Long, String> kafkaProducer = KafkaConfig.getProducer();

        for (int i = 0; i < numberOfMessageToSend; i++) {

            String message = "Message-" + i;
            ProducerRecord<Long, String> record = new ProducerRecord<>(KafkaConstants.TOPIC, 1L, message);

            LOGGER.info("Sending kafka record: {}", record);

            kafkaProducer.send(record);
        }

        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
