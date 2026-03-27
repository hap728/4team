package com.project.mvcgithublogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// 회원가입 설정
@Controller
public class JoinController {

    @GetMapping("/join")
    public String join() {
        return "signup";
    }
}
