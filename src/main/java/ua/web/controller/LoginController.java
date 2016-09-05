package ua.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.web.common.Credentials;

@RestController
public class LoginController {

    @RequestMapping(value = "/login_check", method = RequestMethod.POST)
    public boolean isCorrect(@RequestBody Credentials credentials) {
        return credentials.getName().equals("kos");
    }
}
