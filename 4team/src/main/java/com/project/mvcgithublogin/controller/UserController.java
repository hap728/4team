package com.project.mvcgithublogin.controller;

import com.project.mvcgithublogin.dto.CreateUserRequest;
import com.project.mvcgithublogin.dto.LoginRequest;
import com.project.mvcgithublogin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
   private final UserService userService;

   public UserController(UserService userService) {
      this.userService = userService;
   }

   @PostMapping({"/signup"})
   public String signup(@ModelAttribute CreateUserRequest request) {
      this.userService.signup(request);
      return "redirect:/signup";
   }

   @PostMapping({"/login"})
   public String login(@ModelAttribute LoginRequest request) {
      this.userService.login(request);
      return "redirect:/login";
   }

   @GetMapping({"/users"})
   public String home() {
      return "index";
   }

   @GetMapping({"/signup"})
   public String signup() {
      return "signup";
   }

   @GetMapping({"/login"})
   public String login() { return "login"; }
}
