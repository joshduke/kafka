package learn.kafka.producer.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Value("${kafka.topic}")
    private String kafkaTopic;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publish(String key, String message) {
        ProducerRecord record = new ProducerRecord<>(kafkaTopic, key, message);
        kafkaTemplate.send(record);
    }
}
