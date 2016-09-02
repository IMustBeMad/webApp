package ua.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.web.common.Credentials;

@RestController
public class LoginController {

    @RequestMapping("/login_check")
    public boolean isCorrect(Credentials credentials) {
        return credentials.getName().equals("kos");
    }
}
