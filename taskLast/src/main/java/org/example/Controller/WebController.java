package org.example.Controller;


import org.example.model.UserEntity;
import org.example.service.UserService;
import org.example.model.SmartphoneEntity;
import org.example.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private UserService userService;

    @Autowired
    private SmartphoneService smartphoneService;

    @GetMapping("/web/users")
    public String getUsers(Model model) {
        List<UserEntity> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList"; // Make sure this matches the name of your Thymeleaf template
    }

    @GetMapping("/web/smartphones")
    public String getSmartphones(Model model) {
        List<SmartphoneEntity> smartphones = smartphoneService.getAllSmartphones();
        model.addAttribute("smartphones", smartphones);
        return "smartphoneList";
    }
}
