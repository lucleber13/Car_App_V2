package com.cbcode.car_app_v2.User_Packages.controller;

import com.cbcode.car_app_v2.User_Packages.model.DTO.UserRegisterDto;
import com.cbcode.car_app_v2.User_Packages.services.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegisterDto userRegistrationDto() {
        return new UserRegisterDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegisterDto userRegisterDto) {
        userService.save(userRegisterDto);
        return "redirect:/registration?success";
    }

}
