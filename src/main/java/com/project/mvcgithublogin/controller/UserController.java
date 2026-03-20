package com.project.mvcgithublogin.controller;

import com.project.mvcgithublogin.domain.User;
import com.project.mvcgithublogin.dto.CreateUserRequest;
import com.project.mvcgithublogin.dto.LoginRequest;
import com.project.mvcgithublogin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
   private final UserService userService;

   public UserController(UserService userService) {
      this.userService = userService;
   }

   @PostMapping({"/signup"})
   public String signup(@ModelAttribute CreateUserRequest request) {
      userService.signup(request);
      return "redirect:/login";
   }

   @PostMapping("/login")
   public String login(@ModelAttribute LoginRequest request, HttpSession session) {
      System.out.println("id=" + request.getId() + ", pw=" + request.getPw());
      User user = userService.login(request);
      session.setAttribute("loginUser", user.getId());
      return "redirect:/index";
   }

   @GetMapping({"/index"})
   public String index() {
      return "index";
   }

   @GetMapping({"/signup"})
   public String signup() {
      return "signup";
   }

   @GetMapping({"/login"})
   public String login() { return "login"; }
}
