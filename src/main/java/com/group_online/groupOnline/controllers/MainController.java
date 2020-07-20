package com.group_online.groupOnline.controllers;

import com.group_online.groupOnline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    private final UserRepository userRepository;

    @Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String indexPage(Model model, Principal principal) {
        if (principal != null){
            model.addAttribute("username", principal.getName());
        }
        else {
            model.addAttribute("username", "");
        }

        return "index";
    }
}
