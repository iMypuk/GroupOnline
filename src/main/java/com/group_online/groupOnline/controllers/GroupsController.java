package com.group_online.groupOnline.controllers;

import com.group_online.groupOnline.model.GroupItem;
import com.group_online.groupOnline.model.User;
import com.group_online.groupOnline.repository.GroupItemRepository;
import com.group_online.groupOnline.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class GroupsController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(GroupsController.class);

    private final GroupItemRepository repository;

    private final UserRepository userRepository;

    @Autowired
    public GroupsController(GroupItemRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping("/groups")
    public String groupsPage(Model model, Principal principal) {
        logger.info("User name: {}", principal.getName());
        model.addAttribute("items", repository.findByUserUsername(principal.getName()));
        model.addAttribute("item", new GroupItem());
        return "groups";
    }

    @PostMapping("/groups")
    public String newShoppingItem(GroupItem item, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        item.setUser(user);
        repository.save(item);
        return "redirect:/groups";
    }

    @DeleteMapping("/groups/{id}")
    public String deleteShoppingItem(@PathVariable("id") long id) {
        repository.deleteById(id);
        return "redirect:/groups";
    }

}
