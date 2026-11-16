package io.github.harishvelmurugan14.bookmyshow.services;

import io.github.harishvelmurugan14.bookmyshow.models.*;
import io.github.harishvelmurugan14.bookmyshow.repositories.BookingRepository;
import io.github.harishvelmurugan14.bookmyshow.repositories.ShowRepository;
import io.github.harishvelmurugan14.bookmyshow.repositories.ShowSeatRepository;
import io.github.harishvelmurugan14.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class BookingServiceImpl implements BookingService {

    private final UserRepository userRepository;
    private final ShowSeatRepository showSeatRepository;
    private final ShowRepository showRepository;
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(UserRepository userRepository,
                              ShowSeatRepository showSeatRepository,
                              ShowRepository showRepository,
                              BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking issueTicket(Long userId, List<Long> showSeatIds, Long showId) {

        // 1.Validate user
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid user");
        }
        User bookedBy = userOptional.get();

        // 2.Validate showSeat
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        if (showSeats.isEmpty()) {
            throw new RuntimeException("Show seats invalid");
        }

        // 3. Validate show
        Optional<Show> showOptional = showRepository.findById(showId);
        if (showOptional.isEmpty()) {
            throw new RuntimeException("Invalid Show");
        }

        Show bookedShow = showOptional.get();

        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                if ((showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED)
                        && Duration.between(showSeat.getBookedAt().toInstant(),
                        new Date().toInstant()).toMinutes() > 15)) {
                    throw new RuntimeException("Blocked and yet to be released");
                }
                throw new RuntimeException("Selected seats is already blocked");
            }
        }

        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setBookedAt(new Date());
        }

        showSeatRepository.saveAll(showSeats);


        Booking booking = new Booking();
        booking.setUser(bookedBy);
        booking.setShow(bookedShow);
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.BOOKED);
        booking.setPayments(new ArrayList<>());
        int TICKET_PRICE = 160;
        booking.setAmount(TICKET_PRICE * showSeats.size());

        return bookingRepository.save(booking);
    }
}
