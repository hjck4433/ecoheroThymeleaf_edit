package com.ecohero.ecohero.controller;

import com.ecohero.ecohero.dao.ChallengeDAO;
import com.ecohero.ecohero.vo.ChallengeVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/challenge")
public class ChallengeController {
    @GetMapping("/select")
    public String selectChallenge(Model model){
        ChallengeDAO chldao = new ChallengeDAO();
        List<ChallengeVO> challenge = chldao.challengeSelect();
        model.addAttribute("chlName", challenge);
        return "thymeleafEcoHero/challengeSelect";
    }
    @GetMapping("/insert")
    public String insertViewChallenge(Model model){
        model.addAttribute("chlName", new ChallengeVO());
        return "thymeleafEcoHero/challengeInsert";
    }
    @PostMapping("/insert") //
    public String insertDBChallenge(@ModelAttribute("chlName") ChallengeVO challengeVO){
        ChallengeDAO challengeDAO = new ChallengeDAO();
        challengeDAO.chlInsert(challengeVO);
        return "thymeleafEcoHero/challengeInsertRst";
    }
}

