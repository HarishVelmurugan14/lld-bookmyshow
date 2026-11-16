package io.github.harishvelmurugan14.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {
    @ManyToOne
    private User user;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @OneToMany(mappedBy = "booking")
    private List<Payment> payments;
    private int amount;

}