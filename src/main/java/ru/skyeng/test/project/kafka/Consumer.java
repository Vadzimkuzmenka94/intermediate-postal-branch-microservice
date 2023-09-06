package ru.skyeng.test.project.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.skyeng.test.project.kafka.event.ParcelDeliveryEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer {
    private final ObjectMapper objectMapper;
    private final Producer producer;

    @KafkaListener(topics = "parcel.delivery.topic")
    public void processCarPurchaseEvent(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);
        ParcelDeliveryEvent deliveryEvent = objectMapper.readValue(message, ParcelDeliveryEvent.class);
        producer.sendMessageParcelDelivery(deliveryEvent);
    }
}
