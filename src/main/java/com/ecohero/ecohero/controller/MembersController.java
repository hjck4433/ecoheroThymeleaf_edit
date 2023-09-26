package com.ecohero.ecohero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class MembersController {
    @GetMapping("/select")
    public String selectEmp() {
        System.out.println("여기는 emp select호출문입니다.");
        return "test";
    }


}
