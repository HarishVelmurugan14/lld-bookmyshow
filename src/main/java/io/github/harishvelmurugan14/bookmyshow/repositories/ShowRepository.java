package io.github.harishvelmurugan14.bookmyshow.repositories;

import io.github.harishvelmurugan14.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {
    @Override
    Optional<Show> findById(Long showId);
}
