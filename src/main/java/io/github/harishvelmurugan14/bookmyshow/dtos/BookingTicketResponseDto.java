package io.github.harishvelmurugan14.bookmyshow.dtos;

import io.github.harishvelmurugan14.bookmyshow.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingTicketResponseDto {
    private Long bookingId;
    private ResponseStatus responseStatus;
    private String failureMessage;
}
