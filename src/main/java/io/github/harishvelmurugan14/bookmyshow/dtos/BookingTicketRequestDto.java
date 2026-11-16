package io.github.harishvelmurugan14.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingTicketRequestDto {
    private Long userId;
    List<Long> showSeats;
    private Long showId;
}

