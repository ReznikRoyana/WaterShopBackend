package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;
import ru.profiteam.watershop.domain.enums.MessageContextType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "delivery_service_message")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryServiceMassage extends PersistentObject {

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    User recipient;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    User sender;

    @Column(name = "context")
    String context;

    @Column(name = "message_context_type")
    @Enumerated(EnumType.STRING)
    MessageContextType messageContextType;

    @Column(name = "date")
    String date;
}
