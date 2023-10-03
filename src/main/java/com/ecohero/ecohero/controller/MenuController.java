package com.ecohero.ecohero.controller;

import com.ecohero.ecohero.dao.LoginDAO;
import com.ecohero.ecohero.dao.MembersInsertDAO;
import com.ecohero.ecohero.vo.MembersVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ecohero")
public class MenuController {
    @GetMapping("/login")
    public String ecoheroLogin(Model model) {
        model.addAttribute("userLogin", new MembersVO());
        return "thymeleafEcoHero/ecoheroLogin";
    }
    @PostMapping("/login")
    public String insertDBMembers(@ModelAttribute("userLogin") MembersVO membersVO) {
        LoginDAO loginDAO = new LoginDAO();
        boolean isLogin = loginDAO.checkMember(membersVO.getUserId(), membersVO.getUserPw());
        if(isLogin) {
            return "thymeleafEcoHero/ecoheroMenu";
        }
        else {
            return "thymeleafEcoHero/ecoheroLogin";
        }
    }

    @GetMapping("/menu")
    public String ecoheroMenu() {
        return "thymeleafEcoHero/ecoheroMenu";
    }

}
