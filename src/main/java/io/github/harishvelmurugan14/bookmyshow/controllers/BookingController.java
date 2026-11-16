package io.github.harishvelmurugan14.bookmyshow.controllers;

import io.github.harishvelmurugan14.bookmyshow.dtos.BookingTicketRequestDto;
import io.github.harishvelmurugan14.bookmyshow.dtos.BookingTicketResponseDto;
import io.github.harishvelmurugan14.bookmyshow.models.Booking;
import io.github.harishvelmurugan14.bookmyshow.models.BookingStatus;
import io.github.harishvelmurugan14.bookmyshow.models.ResponseStatus;
import io.github.harishvelmurugan14.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    BookingTicketResponseDto bookTicket(BookingTicketRequestDto bookingTicketRequestDto) {
        BookingTicketResponseDto responseDto = new BookingTicketResponseDto();
        Booking booking = bookingService.issueTicket(bookingTicketRequestDto.getUserId(),
                bookingTicketRequestDto.getShowSeats(), bookingTicketRequestDto.getShowId());

        if(booking.getBookingStatus().equals(BookingStatus.FAILED)) {
            throw new RuntimeException("Booking ticket failed");
        }

        responseDto.setBookingId(booking.getId());
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);

        return responseDto;
    }
}
