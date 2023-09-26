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
        model.addAttribute ("USER_ID", mbsvo);
        return "thymeleafEcoHero/membersSelect";
    }
}

//public String selectEmp(Model model) { // View로 모델을 넘겨주는 객체
//        EmpDAO dao = new EmpDAO();
//        List<EmpVO> emps = dao.empSelect();
//        model.addAttribute("employees", emps);