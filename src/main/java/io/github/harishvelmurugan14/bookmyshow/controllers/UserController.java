package io.github.harishvelmurugan14.bookmyshow.controllers;

import io.github.harishvelmurugan14.bookmyshow.dtos.UserLoginRequestDto;
import io.github.harishvelmurugan14.bookmyshow.dtos.UserLoginResponsetDto;
import io.github.harishvelmurugan14.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserLoginResponsetDto signup(UserLoginRequestDto userLoginRequestDto) {
        return userService.signup(userLoginRequestDto.getUsername(), userLoginRequestDto.getPassword());
    }

    public void login(UserLoginRequestDto userLoginRequestDto) {
        userService.login(userLoginRequestDto.getUsername(), userLoginRequestDto.getPassword());
    }
}
