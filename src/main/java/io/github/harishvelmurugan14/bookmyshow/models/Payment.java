package io.github.harishvelmurugan14.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    @ManyToOne
    private Booking booking;
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    int amount;
}
