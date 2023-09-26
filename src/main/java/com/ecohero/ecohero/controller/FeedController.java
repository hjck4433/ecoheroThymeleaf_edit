package com.ecohero.ecohero.controller;

import com.ecohero.ecohero.dao.FeedDAO;
import com.ecohero.ecohero.vo.FeedVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/feed")
public class FeedController {
    @GetMapping("/select")
    public String feedSelect(Model model) {
        FeedDAO fdao = new FeedDAO();
        List<FeedVO> mvl = fdao.feedSelect();
        model.addAttribute("feeds",mvl);
        return "thymeleafEcoHero/feedSelect";
    }
    @GetMapping("/insert")
    public String feedInsert(Model model) {
        model.addAttribute("newfeed", new FeedVO());
        return "thymeleafEcoHero/feedInsert";
    }

    @PostMapping("/insert")
    public String insertDBFeed(@ModelAttribute("newfeed") FeedVO feedVO) {
        FeedDAO fdao = new FeedDAO();
        fdao.insertFeed(feedVO);
        return "thymeleafEcoHero/feedInsertRst";
    }
}
