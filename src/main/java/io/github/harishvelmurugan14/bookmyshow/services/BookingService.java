package io.github.harishvelmurugan14.bookmyshow.services;

import io.github.harishvelmurugan14.bookmyshow.models.Booking;

import java.util.List;

public interface BookingService {
     Booking issueTicket(Long userId, List<Long> showSeats, Long showId);
}
