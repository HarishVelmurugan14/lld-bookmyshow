package io.github.harishvelmurugan14.bookmyshow.services;

import io.github.harishvelmurugan14.bookmyshow.dtos.UserLoginResponsetDto;

public interface UserService {
    UserLoginResponsetDto signup(String username, String password);
    void login(String username, String password);
}
