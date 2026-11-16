package io.github.harishvelmurugan14.bookmyshow;

import io.github.harishvelmurugan14.bookmyshow.controllers.UserController;
import io.github.harishvelmurugan14.bookmyshow.dtos.UserLoginRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LldBookmyshowApplication implements CommandLineRunner {

    @Autowired
    UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(LldBookmyshowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		UserLoginRequestDto userLoginRequestDto = new UserLoginRequestDto();
		userLoginRequestDto.setUsername("test3@harish.com");
		userLoginRequestDto.setPassword("dummy");
//        userController.signup(userLoginRequestDto);
        userController.login(userLoginRequestDto);
    }
}
