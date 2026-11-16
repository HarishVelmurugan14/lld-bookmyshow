package io.github.harishvelmurugan14.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Seat extends BaseModel {
    private String seatNumber;
    @ManyToOne
    private Screen screen;
    @ManyToOne
    private SeatType seatType;
    private int rowVal;
    private int colVal;
}
