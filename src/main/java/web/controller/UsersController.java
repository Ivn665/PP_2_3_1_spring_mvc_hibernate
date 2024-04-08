package web.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;


@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {

        this.userService = userService;

        if (userService.allUsers().isEmpty()) {
            userService.addUser(new User("Jackie", "Chan", (byte) 69, 100));
            userService.addUser(new User("Bruce", "Lee", (byte) 32, -100));
            userService.addUser(new User("Steven", "Seagal", (byte) 71, 10));
            userService.addUser(new User("Gordon", "Liu", (byte) 72, -200));
        }
    }

    //устанавливаем соответствие между адресом страницы и файлом представления
    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("usersList", userService.allUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") @Valid User user
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        } else {
            userService.addUser(user);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }


    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") @Valid User user
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            userService.editUser(user);
            return "redirect:/";
        }
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
