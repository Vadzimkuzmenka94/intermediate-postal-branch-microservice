package ru.skyeng.test.project.kafka.event;

import lombok.*;
import ru.skyeng.test.project.core.enums.PostType;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParcelDeliveryEvent {
    private UUID id;
    private String senderPassportNumber;
    private PostType postType;
    private String index;
    private String address;
    private String recipientName;
}
