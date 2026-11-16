package io.github.harishvelmurugan14.bookmyshow.repositories;

import io.github.harishvelmurugan14.bookmyshow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Override
    Booking save(Booking entity);
}
