package ru.skyeng.test.project.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.skyeng.test.project.kafka.event.ParcelDeliveryEvent;

@Slf4j
@Component
public class Producer {
    @Value("final.destination.topic")
    private String finalDestinationTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessageParcelDelivery(ParcelDeliveryEvent event)
            throws JsonProcessingException {
        String parcelDeliveryEventAsMessage = objectMapper.writeValueAsString(event);
        kafkaTemplate.send(finalDestinationTopic, parcelDeliveryEventAsMessage);
        log.info("Final destination request produced {}", parcelDeliveryEventAsMessage);
        return "message sent";
    }
}
