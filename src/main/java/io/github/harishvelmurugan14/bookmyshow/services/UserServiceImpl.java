package io.github.harishvelmurugan14.bookmyshow.services;

import io.github.harishvelmurugan14.bookmyshow.dtos.UserLoginResponsetDto;
import io.github.harishvelmurugan14.bookmyshow.models.ResponseStatus;
import io.github.harishvelmurugan14.bookmyshow.models.User;
import io.github.harishvelmurugan14.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserLoginResponsetDto signup(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if(userOptional.isPresent()) {
            throw new RuntimeException("User already present, Try logging in");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setBookings(new ArrayList<>());
        userRepository.save(user);
        UserLoginResponsetDto userLoginResponsetDto = new UserLoginResponsetDto();
        userLoginResponsetDto.setResponseStatus(ResponseStatus.SUCCESS);
        return userLoginResponsetDto;
    }

    @Override
    public void login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty())
        {
            throw new IllegalArgumentException("Username is incorrect");
        }

        User user = userOptional.get();
        if(bCryptPasswordEncoder.matches(password, user.getPassword()))
        {
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            return;
        }

        throw new IllegalArgumentException("Invalid password");
    }
}
