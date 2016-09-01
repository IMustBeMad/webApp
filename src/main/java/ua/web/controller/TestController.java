package ua.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.web.common.User;
import ua.web.manager.DbManager;

@RestController
public class TestController {

    @Autowired
    private DbManager dbManager;

    @RequestMapping("/test")
    public String printTest() {
        User user = new User();
        user.setName("Test");

        dbManager.saveOrUpdate(user);

        return "test";
    }
}
