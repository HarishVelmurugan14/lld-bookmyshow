package io.github.harishvelmurugan14.bookmyshow.repositories;

import io.github.harishvelmurugan14.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long aLong);
    Optional<User> findByUsername(String username);

    @Override
    User save(User user);
}
