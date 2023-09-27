package com.ecohero.ecohero.controller;

import com.ecohero.ecohero.dao.MembersSelectDAO;
import com.ecohero.ecohero.vo.MembersVO;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/members")
public class MembersSelectController {
    @GetMapping("/select")
    public String MembersSelect(Model model) {
        MembersSelectDAO dao = new MembersSelectDAO();
        List<MembersVO> mbsvo = dao.selectMembersInfo();
        model.addAttribute ("userId", mbsvo);
        return "thymeleafEcoHero/membersSelect";
    }

}
