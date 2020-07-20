package com.group_online.groupOnline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class VkController {

    @GetMapping("/groups1")
    public String sendRequest(Model model, Principal principal){

        return "redirect:/groups";
    }
}
